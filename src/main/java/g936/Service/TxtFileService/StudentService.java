package g936.Service.TxtFileService;

import g936.Domain.Student;
import g936.Repository.MemoryRepository.AbstractCrudRepository;

public class StudentService extends AbstractService<String, Student> {
    //StudentFileRepository stdRepo;
    public StudentService(AbstractCrudRepository<String, Student> stdRepo) {
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


