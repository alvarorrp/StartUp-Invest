package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
