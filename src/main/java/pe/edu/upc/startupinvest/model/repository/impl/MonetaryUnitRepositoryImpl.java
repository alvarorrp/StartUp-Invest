package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.MonetaryUnit;
import pe.edu.upc.startupinvest.model.repository.MonetaryUnitRepository;
public class MonetaryUnitRepositoryImpl implements MonetaryUnitRepository {

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<MonetaryUnit> findById(Integer id) throws Exception {
		return findById(id, MonetaryUnit.class);
	}

	@Override
	public List<MonetaryUnit> findAll() throws Exception {
		String jpql = "SELECT monetaryUnits FROM MonetaryUnits monetaryUnits";	
		return findAll(MonetaryUnit.class, jpql);
	}
	
}
