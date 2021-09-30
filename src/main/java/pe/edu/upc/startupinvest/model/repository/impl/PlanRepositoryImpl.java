package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.startupinvest.model.entities.Plan;
import pe.edu.upc.startupinvest.model.entities.PlanHistory;
import pe.edu.upc.startupinvest.model.repository.PlanRepository;
@Named
@ApplicationScoped
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
		String jpql = "SELECT plans FROM Plan plans";	
		return findAll(Plan.class, jpql);
	}


	@Override
	public List<Plan> findByName(String name) {
		List<Plan> entities = new ArrayList<Plan>();
		String jpql = "SELECT plans FROM Plan plans where plans.name LIKE '%" + name + "%'";	
		TypedQuery<Plan> typedQuery = getEntityManager().createQuery(jpql, Plan.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> list() {
		List<Plan>lista =new ArrayList<Plan>();
		try {
			Query q=entityManager.createQuery("From Plan plans");
			lista=(List<Plan>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
