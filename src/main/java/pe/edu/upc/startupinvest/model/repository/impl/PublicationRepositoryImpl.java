package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.startupinvest.model.entities.Plan;
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


	@Override
	public List<Publication> findPublicationByName(String name) {
		String jpql = "SELECT publications FROM Publications publications where publication_name ='"+name+"'";
		List<Publication> entities = new ArrayList<Publication>();
		// Execute Query
		TypedQuery<Publication> typedQuery = getEntityManager().createQuery(jpql, Publication.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Publication> list() {
		List<Publication>lista =new ArrayList<Publication>();
		try {
			Query q=entityManager.createQuery("From Publication publications");
			lista=(List<Publication>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
