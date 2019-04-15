package g936.Service.TxtFileService;

import g936.Domain.TemaLab;
import g936.Exceptions.ValidatorException;
import g936.Repository.MemoryRepository.AbstractCrudRepository;

public class TemaLabService extends AbstractService<Integer, TemaLab> {

    public TemaLabService(AbstractCrudRepository<Integer, TemaLab> repository) {
        super(repository);
    }

    public void prelungireTemaLab(String nr, String descr, String sl, String sp, int sc) throws ValidatorException {
        if (sc <= Integer.parseInt(sp)) {
            String sln = Integer.toString(Integer.parseInt(sl) + 1);
            String[] params = {nr, descr, sln, sp};
            update(params);
        }

    }
}
