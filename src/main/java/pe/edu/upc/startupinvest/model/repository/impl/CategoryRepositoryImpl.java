package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.entities.InvestmentRequest;
import pe.edu.upc.startupinvest.model.repository.CategoryRepository;

@Named
@ApplicationScoped
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
		String jpql = "SELECT categories FROM Category categories";
		return findAll(Category.class, jpql);
	}

	@Override
	public List<Category> findByName(String name) throws Exception {

		String jpql = "SELECT categories FROM Category categories where categories.name LIKE '%" + name + "%'";
		System.out.println(jpql);
		return findAll(Category.class, jpql);
	}

	@Override
	public List<Category> findByState(boolean state) throws Exception {
		String jpql = "select categories from Categories categories where categories.state =" + state;
		return findAll(Category.class, jpql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		List<Category>lista =new ArrayList<Category>();
		try {
			Query q=entityManager.createQuery("From Category Categories");
			lista=(List<Category>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
