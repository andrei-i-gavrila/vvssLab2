package g936.Repository.MemoryRepository;

import g936.Domain.Student;
import g936.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v) {
        super(v);
    }

    @Override
    public Student extractEntity(String[] params) {
        int grupa = 0;
        try {
            grupa = Integer.parseInt(params[2]);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return new Student(params[0], params[1], grupa, params[3], params[4]);
    }
}