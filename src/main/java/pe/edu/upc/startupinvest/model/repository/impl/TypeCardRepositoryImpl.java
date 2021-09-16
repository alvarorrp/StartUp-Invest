package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.TypeCard;
import pe.edu.upc.startupinvest.model.repository.TypeCardRepository;

public class TypeCardRepositoryImpl implements TypeCardRepository {
	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<TypeCard> findById(Integer id) throws Exception {
		return findById(id, TypeCard.class);
	}

	@Override
	public List<TypeCard> findAll() throws Exception {
		String jpql = "SELECT typeCards FROM TypeCards typeCards";
		return findAll(TypeCard.class, jpql);
	}
}
