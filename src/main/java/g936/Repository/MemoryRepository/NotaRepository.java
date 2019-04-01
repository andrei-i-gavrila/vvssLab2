package g936.Repository.MemoryRepository;

import g936.Domain.Nota;
import g936.Validator.IValidator;

import java.time.LocalDateTime;

public class NotaRepository extends AbstractCrudRepository<Integer, Nota> {
    public NotaRepository(IValidator<Nota> v) {
        super(v);
    }

    @Override
    public Nota extractEntity(String[] params) {
        Nota n = new Nota(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Double.parseDouble(params[3]), LocalDateTime.parse(params[4]));
        return n;
    }
}