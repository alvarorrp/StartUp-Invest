package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
