package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.Investor;
import pe.edu.upc.startupinvest.model.entities.PlanHistory;
import pe.edu.upc.startupinvest.model.repository.PlanHistoryRepository;
public class PlanHistoryRepositoryImpl implements PlanHistoryRepository {

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<PlanHistory> findById(Integer id) throws Exception {
		return findById(id, PlanHistory.class);
	}

	@Override
	public List<PlanHistory> findAll() throws Exception {
		String jpql = "SELECT plansHistory FROM PlansHistory plansHistory";	
		return findAll(PlanHistory.class, jpql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanHistory> list() {
		List<PlanHistory>lista =new ArrayList<PlanHistory>();
		try {
			Query q=entityManager.createQuery("From PlanHistory planHistories");
			lista=(List<PlanHistory>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
