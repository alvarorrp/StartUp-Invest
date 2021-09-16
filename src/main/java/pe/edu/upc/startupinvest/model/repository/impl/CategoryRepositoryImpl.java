package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
