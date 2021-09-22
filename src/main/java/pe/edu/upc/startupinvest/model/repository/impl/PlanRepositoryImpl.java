package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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


	@Override
	public List<Plan> findPlanByName(String name) {
		List<Plan> entities = new ArrayList<Plan>();
		String jpql = "SELECT monetaryUnits FROM MonetaryUnits monetaryUnits where name='"+name+"'";	
		TypedQuery<Plan> typedQuery = getEntityManager().createQuery(jpql, Plan.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}
	
}
