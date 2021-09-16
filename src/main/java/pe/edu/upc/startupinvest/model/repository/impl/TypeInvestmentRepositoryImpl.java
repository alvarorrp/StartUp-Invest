package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
import pe.edu.upc.startupinvest.model.repository.TypeInvestmentRepository;
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
	public List<TypeInvestment> findAll() throws Exception {
		String jpql = "SELECT typeInvestments FROM TypesInvestment typeInvestments";
		return findAll(TypeInvestment.class, jpql);
	}
	
}
