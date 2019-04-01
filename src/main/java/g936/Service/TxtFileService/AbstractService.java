package g936.Service.TxtFileService;

import g936.Domain.HasId;
import g936.Exceptions.ValidatorException;
import g936.Repository.MemoryRepository.AbstractCrudRepo;
import g936.Validator.IValidator;

public abstract class AbstractService<ID, E extends HasId<ID>> {
    private IValidator<E> v;
    private AbstractCrudRepo<ID, E> repo;

    public AbstractService(AbstractCrudRepo<ID, E> repo) {
        this.repo = repo;
    }

    //@Override
    public void add(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.save(entity);
    }

    public void del(ID id) throws ValidatorException {
        //E entity = repo.extractEntity(params);
        repo.delete(id);
    }

    public void upd(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.update(entity);
    }

    public Iterable<E> getAll() {
        return repo.findAll();
    }

    public E getById(ID id) {
        return repo.findOne(id);
    }

    public int size() {
        return (int) repo.size();
    }

}

