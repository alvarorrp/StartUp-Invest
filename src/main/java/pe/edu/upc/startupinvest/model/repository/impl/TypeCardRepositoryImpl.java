package pe.edu.upc.startupinvest.model.repository.impl;


import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import pe.edu.upc.startupinvest.model.entities.TypeCard;
import pe.edu.upc.startupinvest.model.repository.TypeCardRepository;

@Named
@ApplicationScoped
public class TypeCardRepositoryImpl implements TypeCardRepository {
	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	/*AQUI VA EL CODIGO*/

	@Override
	public List<TypeCard> findTypeCardByName(String name) throws Exception {
		String jpql = "SELECT typeCards FROM TypeCard typeCards where typeCards.name LIKE '%" + name + "%'";
		System.out.println(jpql);
		return findAll(TypeCard.class, jpql);
	}

	
}
