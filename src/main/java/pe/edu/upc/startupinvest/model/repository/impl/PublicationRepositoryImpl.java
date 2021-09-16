package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.Publication;
import pe.edu.upc.startupinvest.model.repository.PublicationRepository;
public class PublicationRepositoryImpl implements  PublicationRepository{
	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<Publication> findById(Integer id) throws Exception {
		return findById(id, Publication.class);
	}

	@Override
	public List<Publication> findAll() throws Exception {
		String jpql = "SELECT publications FROM Publications publications";	
		return findAll(Publication.class, jpql);
	}
	
}
