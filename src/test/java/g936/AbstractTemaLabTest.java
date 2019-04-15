package g936;

import g936.Domain.TemaLab;
import g936.Exceptions.ValidatorException;
import g936.Repository.MemoryRepository.AbstractCrudRepository;
import g936.Service.TxtFileService.AbstractService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public abstract class AbstractTemaLabTest {

    protected AbstractCrudRepository<Integer, TemaLab> repo;
    protected AbstractService<Integer, TemaLab> service;

    protected abstract AbstractCrudRepository<Integer, TemaLab> getRepoImpl();

    protected abstract AbstractService<Integer, TemaLab> getServiceImpl();

    @Before
    public void setUp() {
        repo = getRepoImpl();
        service = getServiceImpl();
    }

    @After
    public void tearDown() {
        iterableToList(repo.findAll()).stream().map(TemaLab::getId).forEach(repo::delete);
    }

    private String[] toParams(String number, String description, String termenLimita, String dataPredare) {
        return new String[]{number, description, termenLimita, dataPredare};
    }

    private <T> List<T> iterableToList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    @Test
    public void shouldCreateTemaLab() {
        try {
            service.add(toParams("1", "tema 1", "12", "10"));
            assertEquals(1, service.size());
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void shouldFailWhenTermenLimitaIsGreaterThan14() {
        try {
            service.add(toParams("1", "tema 1", "15", "10"));
            fail();
        } catch (ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForEmptyNumber() {
        try {
            service.add(toParams("", "tema 1", "12", "10"));
            fail();
        } catch (NumberFormatException | ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForEmptyDescription() {
        try {
            service.add(toParams("1", "", "12", "10"));
            fail();
        } catch (ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForLimit() {
        try {
            service.add(toParams("1", "11", "", "10"));
            fail();
        } catch (NumberFormatException | ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForDate() {
        try {
            service.add(toParams("1", "11", "10", ""));
            fail();
        } catch (NumberFormatException | ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForLimitBeforeDate() {
        try {
            service.add(toParams("1", "11", "6", "8"));
            fail();
        } catch (NumberFormatException | ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForNotANumber() {
        try {
            service.add(toParams("1", "11", "1", "-8"));
            fail();
        } catch (ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForNegativeLimit() {
        try {
            service.add(toParams("1", "11", "-1", "8"));
            fail();
        } catch (ValidatorException e) {
        }
    }

    @Test
    public void shouldFailForIdNotANumber() {
        try {
            service.add(toParams("asodajosd", "11", "-1", "8"));
            fail();
        } catch (NumberFormatException | ValidatorException e) {
        }
    }
}
