package g936.Service.XMLFileService;

import g936.Domain.HasId;
import g936.Exceptions.ValidatorException;
import g936.Repository.XMLFileRepository.AbstractXMLRepository;

public abstract class AbstractXMLService<ID, E extends HasId<ID>> {
    private AbstractXMLRepository<ID, E> xmlrepo;

    public AbstractXMLService(AbstractXMLRepository<ID, E> xmlrepo) {
        this.xmlrepo = xmlrepo;
    }

    protected abstract E extractEntity(String[] params);

    public void add(String[] params) throws ValidatorException {
        E e = extractEntity(params);
        xmlrepo.save(e);
    }

    public void remove(ID id) {
        xmlrepo.delete(id);
    }

    public void update(String[] params) {
        E s = extractEntity(params);
        xmlrepo.update(s);
    }

    public E findOne(ID id) {
        return xmlrepo.findOne(id);
    }

    public Iterable<E> findAll() {
        return xmlrepo.findAll();
    }

    public int getSize() {
        return xmlrepo.getSize();
    }
}