package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.TypeCard;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.TypeCardRepository;
import pe.edu.upc.startupinvest.service.crud.TypeCardService;

public class TypeCardServiceImpl implements TypeCardService {

	@Inject
	private TypeCardRepository typeCardRepository;

	@Override
	public JpaRepository<TypeCard, Integer> getJpaRepository() {
		return typeCardRepository;
	}
}
