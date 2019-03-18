package g936.Service.TxtFileService;

import g936.Domain.Nota;
import g936.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo) {
        super(notaRepo);
    }
}
