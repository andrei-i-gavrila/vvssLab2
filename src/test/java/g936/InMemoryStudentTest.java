package g936;

import g936.Domain.Student;
import g936.Repository.MemoryRepository.AbstractCrudRepo;
import g936.Repository.MemoryRepository.StudentRepo;
import g936.Repository.TxtFileRepository.StudentFileRepo;
import g936.Service.TxtFileService.AbstractService;
import g936.Service.TxtFileService.StudentService;
import g936.Validator.StudentValidator;

public class InMemoryStudentTest extends AbstractStudentTest {
    @Override
    protected AbstractCrudRepo<String, Student> getRepoImpl() {
        return new StudentRepo(new StudentValidator());
    }

    @Override
    protected AbstractService<String, Student> getServiceImpl() {
        return new StudentService(repo);
    }
}
