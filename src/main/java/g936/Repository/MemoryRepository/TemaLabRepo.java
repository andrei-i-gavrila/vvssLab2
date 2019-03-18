package g936.Repository.MemoryRepository;

import g936.Domain.TemaLab;
import g936.Validator.IValidator;

public class TemaLabRepo extends AbstractCrudRepo<Integer, TemaLab> {

    public TemaLabRepo(IValidator<TemaLab> v) {

        super(v);
    }

    public void prelungireTermenLimita(TemaLab t, int saptCurenta) {
        if (saptCurenta <= t.getSaptammanaPredarii()) {
            t.setTermenLimita(t.getTermenLimita() + 1);
            update(t);
        }
    }

}