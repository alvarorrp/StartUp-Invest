package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.startupinvest.model.entities.TypeCard;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.TypeCardRepository;
import pe.edu.upc.startupinvest.service.crud.TypeCardService;

@Named
@ApplicationScoped
public class TypeCardServiceImpl implements TypeCardService {

	@Inject
	private TypeCardRepository typeCardRepository;

	@Override
	public JpaRepository<TypeCard, Integer> getJpaRepository() {
		return typeCardRepository;
	}

	@Override
	public Optional<TypeCard> findById(Integer id) throws Exception {
		return typeCardRepository.findById(id);
	}

	@Override
	public List<TypeCard> findAll() throws Exception {
		return typeCardRepository.findAll();
	}

	@Override
	public List<TypeCard> findTypeCardByName(String name) throws Exception {
		return typeCardRepository.findTypeCardByName(name);
	}
}
