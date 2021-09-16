package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.Resource;
import pe.edu.upc.startupinvest.model.repository.ResourceRepository;
public class ResourceRepositoryImpl implements  ResourceRepository{

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<Resource> findById(Integer id) throws Exception {
		return findById(id, Resource.class);
	}

	@Override
	public List<Resource> findAll() throws Exception {
		String jpql = "SELECT resources FROM Resources resources";	
		return findAll(Resource.class, jpql);
	}
	
}
