package g936;

import g936.Domain.Student;
import g936.Exceptions.ValidatorException;
import g936.Repository.MemoryRepository.AbstractCrudRepository;
import g936.Service.TxtFileService.AbstractService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public abstract class AbstractStudentTest {

    protected AbstractCrudRepository<String, Student> repo;
    protected AbstractService<String, Student> service;

    protected abstract AbstractCrudRepository<String, Student> getRepoImpl();

    protected abstract AbstractService<String, Student> getServiceImpl();

    @Before
    public void setUp() {
        repo = getRepoImpl();
        service = getServiceImpl();
    }

    @After
    public void tearDown() {
        iterableToList(repo.findAll()).stream().map(Student::getId).forEach(repo::delete);
    }

    private String[] toParams(String id, String nume, String grupa, String email, String prof) {
        return new String[]{id, nume, grupa, email, prof};
    }

    private <T> List<T> iterableToList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    @Test
    public void shouldCreateStudent() {
        try {
            service.add(toParams("1", "Xulescu yulesc", "936", "email@test.com", "Profulesc"));
            assertEquals(1, iterableToList(service.getAll()).size());
            Student student = service.getById("1");
            assertEquals("1", student.getId());
            assertEquals("Xulescu yulesc", student.getNume());
            assertEquals(936, student.getGrupa());
            assertEquals("email@test.com", student.getEmail());
            assertEquals("Profulesc", student.getIndrumator());
        } catch (ValidatorException e) {
            fail();
        }
    }

    @Test
    public void shouldFailForEmptyId() {
        try {
            service.add(toParams("", "Xulescu yulesc", "936", "email@test.com", "Profulesc"));
            fail();
        } catch (ValidatorException e) {
            assertEquals("Id invalid", e.getMessage().trim());
        }
    }

    @Test
    public void shouldFailForEmptyName() {
        try {
            service.add(toParams("1", "", "936", "email@test.com", "Profulesc"));
            fail();
        } catch (ValidatorException e) {
            assertEquals("Nume invalid", e.getMessage().trim());
        }
    }

    @Test
    public void shouldFailForGroupNotANumber() {
        try {
            service.add(toParams("1", "Name", "not a number", "email@test.com", "Profulesc"));
            fail();
        } catch (ValidatorException ignored) {
        }
    }

    @Test
    public void shouldFailForGroupNegative() {
        try {
            service.add(toParams("1", "Name", "-1", "email@test.com", "Profulesc"));
            fail();
        } catch (ValidatorException ignored) {
        }
    }

    @Test
    public void shouldPassForGroupZero() {
        try {
            service.add(toParams("1", "Name", "0", "email@test.com", "Profulesc"));
        } catch (ValidatorException ignored) {
            fail();
        }
    }

    @Test
    public void shouldFailForInvalidMail() {
        try {
            service.add(toParams("1", "Name", "1", "email", "Profulesc"));
            fail();
        } catch (ValidatorException ignored) {
        }
    }

    @Test
    public void shouldFailForEmptyMail() {
        try {
            service.add(toParams("1", "Name", "0", "", "Profulesc"));
            fail();
        } catch (ValidatorException ignored) {
        }
    }

    @Test
    public void shouldFailForEmptyProfessor() {
        try {
            service.add(toParams("1", "Name", "0", "email@email.com", ""));
            fail();
        } catch (ValidatorException ignored) {
        }
    }
}
