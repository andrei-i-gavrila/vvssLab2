package g936;

import g936.Domain.TemaLab;
import g936.Repository.MemoryRepository.AbstractCrudRepository;
import g936.Repository.MemoryRepository.TemaLabRepository;
import g936.Service.TxtFileService.AbstractService;
import g936.Service.TxtFileService.TemaLabService;
import g936.Validator.TemaLabValidator;

public class InMemoryTemaLabTestImpl extends AbstractTemaLabTest {
    @Override
    protected AbstractCrudRepository<Integer, TemaLab> getRepoImpl() {
        return new TemaLabRepository(new TemaLabValidator());
    }

    @Override
    protected AbstractService<Integer, TemaLab> getServiceImpl() {
        return new TemaLabService(repo);
    }
}
