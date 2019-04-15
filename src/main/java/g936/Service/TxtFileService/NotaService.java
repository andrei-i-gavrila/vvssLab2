package g936.Service.TxtFileService;

import g936.Domain.Nota;
import g936.Repository.MemoryRepository.AbstractCrudRepository;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(AbstractCrudRepository<Integer, Nota> notaRepo) {
        super(notaRepo);
    }
}
