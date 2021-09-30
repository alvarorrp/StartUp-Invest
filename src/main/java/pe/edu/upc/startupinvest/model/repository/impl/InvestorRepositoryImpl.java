package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.Investor;
import pe.edu.upc.startupinvest.model.entities.InvestorHistory;
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Investor> list() {
		List<Investor>lista =new ArrayList<Investor>();
		try {
			Query q=entityManager.createQuery("From Investor investors");
			lista=(List<Investor>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
