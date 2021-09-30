package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
import pe.edu.upc.startupinvest.model.repository.TypeInvestmentRepository;
@Named
@ApplicationScoped
public class TypeInvestmentRepositoryImpl  implements TypeInvestmentRepository{

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<TypeInvestment> findById(Integer id) throws Exception {
		return findById(id, TypeInvestment.class);
	}

	@Override
	public List<TypeInvestment> findByName(String name) throws Exception {

		String jpql = "SELECT typeInvestments FROM TypeInvestment typeInvestments where typeInvestments.name LIKE '%" + name + "%'";
		System.out.println(jpql);
		return findAll(TypeInvestment.class, jpql);
	}
	
	@Override
	public List<TypeInvestment> findAll() throws Exception {
		String jpql = "SELECT typeInvestments FROM TypeInvestment typeInvestments";
		return findAll(TypeInvestment.class, jpql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TypeInvestment> list() {
		List<TypeInvestment>lista =new ArrayList<TypeInvestment>();
		try {
			Query q=entityManager.createQuery("From TypeInvestment typeInvestments");
			lista=(List<TypeInvestment>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
