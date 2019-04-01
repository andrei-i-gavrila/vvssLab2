package g936.Service.TxtFileService;

import g936.Domain.Nota;
import g936.Repository.TxtFileRepository.NotaFileRepository;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepository notaRepo) {
        super(notaRepo);
    }
}
