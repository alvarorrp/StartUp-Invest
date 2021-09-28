package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.Startup;
import pe.edu.upc.startupinvest.model.repository.StartupRepository;

@Named
@ApplicationScoped
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
	public List<Startup> findByName(String name) throws Exception {
		String jpql = "SELECT Startups FROM Startups startups where  startups.startup_name ='" + name + "'";
		return findAll(Startup.class, jpql);
	}

	@Override
	public List<Startup> findByState(Boolean state) throws Exception {
		String jpql = "SELECT startups FROM Startups startups where  startups.startup_state =" + state;
		return findAll(Startup.class, jpql);
	}

	@Override
	public List<Startup> findByDateRecently() throws Exception {
		String jpql = "SELECT startups FROM Startups startups where startups.startup_register_date = (SELECT MAX(startups.startup_register_date) FROM Startups)";
		return findAll(Startup.class, jpql);
	}

	@Override
	public List<Startup> findByDateBetween(Date date1, Date date2) throws Exception {
		String jpql = "SELECT startups FROM Startups startups \r\n" + "WHERE startups.startup_register_date BETWEEN '"
				+ date1 + "' and '" + date2 + "'";
		return findAll(Startup.class, jpql);
	}

	@Override
	public List<Startup> findByPopular() throws Exception {
		String jpql = "SELECT   startups.startup_id,investmentrequests.investment_request_id, count(investorhistories.investor_id) as \"numero de inversionistas\"\r\n"
				+ "FROM Startups startups  JOIN InvestmentRequests investmentrequests \r\n"
				+ "on startups.startup_id = investmentrequests.startup_id  JOIN InvestorHistories investorhistories\r\n"
				+ "on investorhistories.investment_request_id = investmentrequests.investment_request_id\r\n"
				+ "group by startups.startup_id,investmentrequests.investment_request_id\r\n" + "limit 6";
		return findAll(Startup.class, jpql);
	}
}
