package g936.Service.XMLFileService;

import g936.Domain.TemaLab;
import g936.Exceptions.ValidatorException;
import g936.Repository.XMLFileRepository.TemaLabXMLRepository;

public class TemaLabXMLService extends AbstractXMLService<Integer, TemaLab> {
    public TemaLabXMLService(TemaLabXMLRepository xmlrepo) {
        super(xmlrepo);
    }

    public void prelungireTemaLab(String nr, String descr, String sl, String sp, int sc) throws ValidatorException {
        if (sc <= Integer.parseInt(sp)) {
            String sln = Integer.toString(Integer.parseInt(sl) + 1);
            String[] params = {nr, descr, sln, sp};
            update(params);
        }

    }

    @Override
    protected TemaLab extractEntity(String[] params) {
        return new TemaLab(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
    }

}