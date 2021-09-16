package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.Investor;
import pe.edu.upc.startupinvest.model.repository.InvestorRepository;
public class InvestorRepositoryImpl implements InvestorRepository{
	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<Investor> findById(Integer id) throws Exception {
		return findById(id, Investor.class);
	}

	@Override
	public List<Investor> findAll() throws Exception {
		String jpql = "SELECT investors FROM Investors investors";	
		return findAll(Investor.class, jpql);
	}
}
