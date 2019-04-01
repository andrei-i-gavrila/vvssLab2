package g936.Repository.TxtFileRepository;

import g936.Domain.HasId;
import g936.Domain.TemaLab;
import g936.Validator.TemaLabValidator;

import java.io.IOException;

public class TemaLabFileRepository extends AbstractFileRepository {
    public TemaLabFileRepository(String filename, TemaLabValidator val) throws IOException {
        super(val, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        int id = Integer.parseInt(info[0]);
        String descr = info[1];
        int sptLim = Integer.parseInt(info[2]);
        int sptPred = Integer.parseInt(info[3]);
        TemaLab t = new TemaLab(id, descr, sptLim, sptPred);
        return t;

    }
}