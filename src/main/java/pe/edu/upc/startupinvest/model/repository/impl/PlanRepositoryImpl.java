package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.Plan;
import pe.edu.upc.startupinvest.model.repository.PlanRepository;

public class PlanRepositoryImpl  implements PlanRepository{
	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<Plan> findById(Integer id) throws Exception {
		return findById(id, Plan.class);
	}

	@Override
	public List<Plan> findAll() throws Exception {
		String jpql = "SELECT plans FROM Plans plans";	
		return findAll(Plan.class, jpql);
	}
	
}
