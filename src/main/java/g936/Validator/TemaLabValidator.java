package g936.Validator;

import g936.Domain.TemaLab;
import g936.Exceptions.ValidatorException;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        if (t.getId() == null) {
            throw new ValidatorException("Nr tema invalid\n");
        } else if (t.getDescriere() == null || t.getDescriere().equals("")) {
            throw new ValidatorException("Descriere tema invalida\n");
        } else if (t.getSaptammanaPredarii() <= 0 || t.getSaptammanaPredarii() > 14) {
            throw new ValidatorException("Sapatamana predarii invalida\n");
        } else if (t.getTermenLimita() <= 0 || t.getTermenLimita() > 14) {
            throw new ValidatorException("Termen limita invalid\n");
        } else if (t.getTermenLimita() <= t.getSaptammanaPredarii()) {
            throw new ValidatorException("Termen limita inainte de predare\n");
        }
    }
}
