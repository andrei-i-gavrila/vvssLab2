package g936.Repository.MemoryRepository;

import g936.Domain.HasId;
import g936.Exceptions.ValidatorException;
import g936.Repository.Repository;
import g936.Validator.IValidator;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudRepository<ID, E extends HasId<ID>> implements Repository<ID, E> {
    private Map<ID, E> entities;
    private IValidator<E> validator;

    public AbstractCrudRepository(IValidator<E> validator) {
        entities = new HashMap<>();
        this.validator = validator;
    }

    @Override
    public E findOne(ID id) {
        if (entities.get(id) == null) {
            return null;
        } else if (id == null) {
            throw new IllegalArgumentException();
        } else {
            return entities.get(id);
        }

    }

    @Override
    public Iterable<E> findAll() {
        return entities.values();
    }

    @Override
    public E save(E entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity can not be null!\n");
        }
        try {
            validator.validate(entity);
            return entities.putIfAbsent(entity.getId(), entity);
        } catch (ValidatorException ex) {
            throw new ValidatorException(ex.getMessage());
        }
    }

    @Override
    public E delete(ID id) {
        return entities.remove(id);
    }

    @Override
    public E update(E entity) {
        try {
            if (entity == null) {
                throw new IllegalArgumentException("Entity can not be null!\n");
            }
            validator.validate(entity);
            return entities.replace(entity.getId(), entity);
        } catch (ValidatorException e) {
            return null;
        }
    }

    //@Override
    public long size() {
        return entities.size();
    }

    public abstract E extractEntity(String[] params);
}