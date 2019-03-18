package g936.Repository.MemoryRepository;

import g936.Domain.Nota;
import g936.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer, Nota> {
    public NotaRepo(IValidator<Nota> v) {
        super(v);
    }
}