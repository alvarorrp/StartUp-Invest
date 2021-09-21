package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.repository.CategoryRepository;
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<Category> findById(Integer id) throws Exception {
		return findById(id, Category.class);
	}

	
	
	@Override
	public List<Category> findAll() throws Exception {
		String jpql = "SELECT categories FROM Categories categories";	
		return findAll(Category.class, jpql);
	}


	@Override
	 public List<Category> findByCategoryName(String name) {

		String jpql = "SELECT categories FROM Categories categories where category_name='"+name+"'";
		List<Category> entities = new ArrayList<Category>();
		// Execute Query
		TypedQuery<Category> typedQuery = getEntityManager().createQuery(jpql, Category.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}


	@Override
	public List<Category> findByCategoryState(boolean state) {
		String jpql= "select categories from Categories categories where categories.category_state ="+state;
		List<Category>entities=new ArrayList<Category>();
		TypedQuery<Category> typedQuery=getEntityManager().createQuery(jpql,Category.class);
		entities=typedQuery.getResultList();
		return entities;
	}

}
