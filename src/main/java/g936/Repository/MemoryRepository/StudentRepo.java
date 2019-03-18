package g936.Repository.MemoryRepository;

import g936.Domain.Student;
import g936.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v) {
        super(v);
    }
}