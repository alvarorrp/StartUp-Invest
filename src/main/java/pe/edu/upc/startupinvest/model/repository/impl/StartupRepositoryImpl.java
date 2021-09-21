package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.entities.Startup;
import pe.edu.upc.startupinvest.model.repository.StartupRepository;

public class StartupRepositoryImpl implements StartupRepository {

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<Startup> findById(Integer id) throws Exception {
		return findById(id, Startup.class);
	}

	@Override
	public List<Startup> findAll() throws Exception {
		String jpql = "SELECT startups FROM Startups startups";
		return findAll(Startup.class, jpql);
	}

	@Override
	public List<Startup> findStartupByName(String name) {
		String jpql = "SELECT Startups FROM Startups startups where  startups.startup_name ='"+name+"'";
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}

	@Override
	public List<Startup> findStartupByState(Boolean state) {
		String jpql = "SELECT Startups FROM Startups startups where  startups.startup_state ="+state;
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}
}
