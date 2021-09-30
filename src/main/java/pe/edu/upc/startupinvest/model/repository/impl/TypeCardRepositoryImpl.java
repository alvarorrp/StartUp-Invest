package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.startupinvest.model.entities.Startup;
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

	@Override
	public List<TypeCard> findTypeCardByname(String name) {
		String jpql = "SELECT typecards FROM TypeCards typecards where typecards.type_card_name ='"+name+"'";
		List<TypeCard> entities = new ArrayList<TypeCard>();
		// Execute Query
		TypedQuery<TypeCard> typedQuery = getEntityManager().createQuery(jpql, TypeCard.class);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TypeCard> list() {
		List<TypeCard>lista =new ArrayList<TypeCard>();
		try {
			Query q=entityManager.createQuery("From TypeCard typeCards");
			lista=(List<TypeCard>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
