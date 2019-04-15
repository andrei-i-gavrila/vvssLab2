package g936.Repository.MemoryRepository;

import g936.Domain.TemaLab;
import g936.Validator.IValidator;

public class TemaLabRepository extends AbstractCrudRepository<Integer, TemaLab> {

    public TemaLabRepository(IValidator<TemaLab> v) {
        super(v);
    }

    @Override
    public TemaLab extractEntity(String[] params) {
        return new TemaLab(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
    }
}