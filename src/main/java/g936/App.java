package g936;

import g936.Exceptions.ValidatorException;
import g936.Repository.XMLFileRepository.NotaXMLRepository;
import g936.Repository.XMLFileRepository.StudentXMLRepository;
import g936.Repository.XMLFileRepository.TemaLabXMLRepository;
import g936.Service.XMLFileService.NotaXMLService;
import g936.Service.XMLFileService.StudentXMLService;
import g936.Service.XMLFileService.TemaLabXMLService;
import g936.UI.ui;
import g936.Validator.NotaValidator;
import g936.Validator.StudentValidator;
import g936.Validator.TemaLabValidator;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs = new StudentValidator();
        TemaLabValidator vt = new TemaLabValidator();
        NotaValidator vn = new NotaValidator();
        StudentXMLRepository strepo = new StudentXMLRepository(vs, "StudentiXML.xml");
        TemaLabXMLRepository tmrepo = new TemaLabXMLRepository(vt, "TemaLaboratorXML.xml");
        NotaXMLRepository ntrepo = new NotaXMLRepository(vn, "NotaXML.xml");
        StudentXMLService stsrv = new StudentXMLService(strepo);
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv = new NotaXMLService(ntrepo);
        ui ui = new ui(stsrv, tmsrv, ntsrv);
        ui.run();
    }
}