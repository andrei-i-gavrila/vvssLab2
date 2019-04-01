package g936.Repository;

import g936.Exceptions.ValidatorException;

/**
 * CRUD operations repository interface
 *
 * @param <ID> - type E must have an attribute of type ID
 * @param <E>  - type of entities saved in repository
 */

public interface Repository<ID, E> {
    E findOne(ID id);

    Iterable<E> findAll();

    E save(E entity) throws ValidatorException;

    E delete(ID id);

    E update(E entity);
}
