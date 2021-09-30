package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.Publication;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.PublicationRepository;
import pe.edu.upc.startupinvest.service.crud.PublicationService;

public class PublicationServiceImpl implements PublicationService {

	@Inject
	private PublicationRepository publicationRepository;

	@Override
	public JpaRepository<Publication, Integer> getJpaRepository() {
		return publicationRepository;
	}
	@Override
	public List<Publication> list() {
		// TODO Auto-generated method stub
		return publicationRepository.list();
	}
}
