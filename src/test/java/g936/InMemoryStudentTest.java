package g936;

import g936.Domain.Student;
import g936.Repository.MemoryRepository.AbstractCrudRepository;
import g936.Repository.MemoryRepository.StudentRepository;
import g936.Service.TxtFileService.AbstractService;
import g936.Service.TxtFileService.StudentService;
import g936.Validator.StudentValidator;

public class InMemoryStudentTest extends AbstractStudentTest {
    @Override
    protected AbstractCrudRepository<String, Student> getRepoImpl() {
        return new StudentRepository(new StudentValidator());
    }

    @Override
    protected AbstractService<String, Student> getServiceImpl() {
        return new StudentService(repo);
    }
}
