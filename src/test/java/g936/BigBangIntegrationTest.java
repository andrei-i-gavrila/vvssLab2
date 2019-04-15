package g936;


import g936.Domain.Nota;
import g936.Domain.Student;
import g936.Domain.TemaLab;
import g936.Exceptions.ValidatorException;
import g936.Repository.MemoryRepository.AbstractCrudRepository;
import g936.Repository.MemoryRepository.NotaRepository;
import g936.Repository.MemoryRepository.StudentRepository;
import g936.Repository.MemoryRepository.TemaLabRepository;
import g936.Service.TxtFileService.AbstractService;
import g936.Service.TxtFileService.NotaService;
import g936.Service.TxtFileService.StudentService;
import g936.Service.TxtFileService.TemaLabService;
import g936.Validator.NotaValidator;
import g936.Validator.StudentValidator;
import g936.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class BigBangIntegrationTest {

    protected AbstractCrudRepository<String, Student> studentRepository;
    protected AbstractService<String, Student> studentService;

    protected AbstractCrudRepository<Integer, TemaLab> assignmentRepository;
    protected AbstractService<Integer, TemaLab> assignmentService;


    protected AbstractCrudRepository<Integer, Nota> gradeRepository;
    protected AbstractService<Integer, Nota> gradeService;


    @Before
    public void setUp() {
        studentRepository = new StudentRepository(new StudentValidator());
        studentService = new StudentService(studentRepository);

        assignmentRepository = new TemaLabRepository(new TemaLabValidator());
        assignmentService = new TemaLabService(assignmentRepository);

        gradeRepository = new NotaRepository(new NotaValidator());
        gradeService = new NotaService(gradeRepository);
    }

    @Test
    public void testAddStudent() throws ValidatorException {
        testAddStudentImpl();
    }

    private void testAddStudentImpl() throws ValidatorException {
        studentService.add(new String[]{"123", "Andrei", "936", "gaie2125@scs.ubbcluj.ro", "Gabi"});
        assertEquals(1, studentService.size());
        Student student = studentService.getById("123");
        assertEquals("123", student.getId());
        assertEquals("Andrei", student.getNume());
        assertEquals(936, student.getGrupa());
        assertEquals("gaie2125@scs.ubbcluj.ro", student.getEmail());
        assertEquals("Gabi", student.getIndrumator());
    }

    @Test
    public void testAddAssignment() throws ValidatorException {
        testAddAssignmentImpl();
    }

    private void testAddAssignmentImpl() throws ValidatorException {
        assignmentService.add(new String[]{"1", "tema 1", "10", "8"});

        assertEquals(1, assignmentService.size());
        TemaLab assignment = assignmentService.getById(1);
        assertEquals(Integer.valueOf(1), assignment.getId());
        assertEquals("tema 1", assignment.getDescriere());
        assertEquals(10, assignment.getTermenLimita());
        assertEquals(8, assignment.getSaptammanaPredarii());
    }

    @Test
    public void testAddGrade() throws ValidatorException {
        testAddGradeImpl();
    }

    private void testAddGradeImpl() throws ValidatorException {
        LocalDateTime now = LocalDateTime.now();
        gradeService.add(new String[]{"1", "123", "2", "10", now.toString()});

        assertEquals(1, gradeService.size());
        Nota grade = gradeService.getById(1);

        assertEquals(Integer.valueOf(1), grade.getId());
        assertEquals("123", grade.getStudentId());
        assertEquals(Integer.valueOf(2), grade.getTemaLabId());
        assertEquals(10, grade.getValoare(), .1);
        assertEquals(now, grade.getLdt());
    }

    @Test
    public void testAll() throws ValidatorException {
        testAddStudentImpl();
        testAddAssignmentImpl();
        testAddGradeImpl();
    }

}
