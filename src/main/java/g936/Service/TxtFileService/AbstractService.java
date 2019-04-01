package g936.Service.TxtFileService;

import g936.Domain.HasId;
import g936.Exceptions.ValidatorException;
import g936.Repository.MemoryRepository.AbstractCrudRepository;

public abstract class AbstractService<ID, E extends HasId<ID>> {
    private AbstractCrudRepository<ID, E> repository;

    public AbstractService(AbstractCrudRepository<ID, E> repository) {
        this.repository = repository;
    }

    public void add(String[] params) throws ValidatorException {
        E entity = repository.extractEntity(params);
        repository.save(entity);
    }

    public void delete(ID id) {
        repository.delete(id);
    }

    public void update(String[] params) {
        E entity = repository.extractEntity(params);
        repository.update(entity);
    }

    public Iterable<E> getAll() {
        return repository.findAll();
    }

    public E getById(ID id) {
        return repository.findOne(id);
    }

    public int size() {
        return (int) repository.size();
    }

}

