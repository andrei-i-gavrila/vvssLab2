package g936;

import g936.Exceptions.ValidatorException;
import org.junit.Test;

public class IncrementalIntegrationTest extends AbstractIntegrationTest {
    @Test
    public void testAddStudent() throws ValidatorException {
        testAddStudentImpl();
    }

    @Test
    public void testAddAssignment() throws ValidatorException {
        testAddStudent();
        testAddAssignmentImpl();
    }

    @Test
    public void testAddGrade() throws ValidatorException {
        testAddStudent();
        testAddAssignmentImpl();
        testAddGradeImpl();
    }
}
