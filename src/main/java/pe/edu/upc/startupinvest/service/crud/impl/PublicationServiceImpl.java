package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.startupinvest.model.entities.Publication;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.PublicationRepository;
import pe.edu.upc.startupinvest.service.crud.PublicationService;

@Named
@ApplicationScoped
public class PublicationServiceImpl implements PublicationService {

	@Inject
	private PublicationRepository publicationRepository;

	@Override
	public JpaRepository<Publication, Integer> getJpaRepository() {
		return publicationRepository;
	}

	@Override
	public Optional<Publication> findById(Integer id) throws Exception {
		return publicationRepository.findById(id);
	}

	@Override
	public List<Publication> findAll() throws Exception {
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findPublicationByName(String name) throws Exception {
		return publicationRepository.findPublicationByName(name);
	}

}
