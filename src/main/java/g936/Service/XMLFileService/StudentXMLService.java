package g936.Service.XMLFileService;

import g936.Domain.Student;
import g936.Repository.XMLFileRepository.StudentXMLRepository;

public class StudentXMLService extends AbstractXMLService<String, Student> {
    private StudentXMLRepository xmlrepo;

    public StudentXMLService(StudentXMLRepository xmlrepo) {
        super(xmlrepo);
    }

    @Override
    protected Student extractEntity(String[] params) {
        int grupa = 0;
        try {
            grupa = Integer.parseInt(params[2]);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return new Student(params[0], params[1], grupa, params[3], params[4]);
    }

}