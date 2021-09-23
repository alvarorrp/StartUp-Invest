package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


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
	public List<Startup> findByName(String name) {
		String jpql = "SELECT Startups FROM Startups startups where  startups.startup_name ='" + name + "'";
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		// Getting result list
		entities = typedQuery.getResultList();
		return entities;
	}

	@Override
	public List<Startup> findByState(Boolean state) {
		String jpql = "SELECT startups FROM Startups startups where  startups.startup_state =" + state;
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		// Getting result list
		entities = typedQuery.getResultList();
		return entities;
	}

	@Override
	public List<Startup> findByDateRecently() {
		String jpql = "SELECT startups FROM Startups startups where startups.startup_register_date = (SELECT MAX(startups.startup_register_date) FROM Startups)";
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		entities = typedQuery.getResultList();
		return entities;
	}

	@Override
	public List<Startup> findByDateBetween(Date date1, Date date2) {
		String jpql = "SELECT startups FROM Startups startups \r\n" + "WHERE startups.startup_register_date BETWEEN '"
				+ date1 + "' and '" + date2 + "'";
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		entities = typedQuery.getResultList();
		return entities;
	}

	@Override
	public List<Startup> findByPopular() {
		String jpql = "SELECT   startups.startup_id,investmentrequests.investment_request_id, count(investorhistories.investor_id) as \"numero de inversionistas\"\r\n"
				+ "FROM Startups startups  JOIN InvestmentRequests investmentrequests \r\n"
				+ "on startups.startup_id = investmentrequests.startup_id  JOIN InvestorHistories investorhistories\r\n"
				+ "on investorhistories.investment_request_id = investmentrequests.investment_request_id\r\n"
				+ "group by startups.startup_id,investmentrequests.investment_request_id\r\n"
				+ "limit 6";
		List<Startup> entities = new ArrayList<Startup>();
		// Execute Query
		TypedQuery<Startup> typedQuery = getEntityManager().createQuery(jpql, Startup.class);
		entities = typedQuery.getResultList();
		return entities;
	}
}
