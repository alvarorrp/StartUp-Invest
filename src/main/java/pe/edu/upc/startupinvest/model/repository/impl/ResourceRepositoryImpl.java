package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.Publication;
import pe.edu.upc.startupinvest.model.entities.Resource;
import pe.edu.upc.startupinvest.model.repository.ResourceRepository;
public class ResourceRepositoryImpl implements  ResourceRepository{

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<Resource> findById(Integer id) throws Exception {
		return findById(id, Resource.class);
	}

	@Override
	public List<Resource> findAll() throws Exception {
		String jpql = "SELECT resources FROM Resources resources";	
		return findAll(Resource.class, jpql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> list() {
		List<Resource>lista =new ArrayList<Resource>();
		try {
			Query q=entityManager.createQuery("From Resource resources");
			lista=(List<Resource>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
