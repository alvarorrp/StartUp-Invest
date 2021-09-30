package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.entities.InvestorHistory;
import pe.edu.upc.startupinvest.model.repository.InvestorHistoryRepository;

public class InvestorHistoryRepositoryImpl implements InvestorHistoryRepository {

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<InvestorHistory> findById(Integer id) throws Exception {
		return findById(id, InvestorHistory.class);
	}

	@Override
	public List<InvestorHistory> findAll() throws Exception {
		String jpql = "SELECT investorHistories FROM InvestorHistories investorHistories";
		return findAll(InvestorHistory.class, jpql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvestorHistory> list() {
		List<InvestorHistory>lista =new ArrayList<InvestorHistory>();
		try {
			Query q=entityManager.createQuery("From InvestorHistory investorHistories");
			lista=(List<InvestorHistory>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
