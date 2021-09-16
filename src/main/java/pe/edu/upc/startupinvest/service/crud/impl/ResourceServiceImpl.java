package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.Resource;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.ResourceRepository;
import pe.edu.upc.startupinvest.service.crud.ResourceService;

public class ResourceServiceImpl implements ResourceService {

	@Inject
	private ResourceRepository resourceRepository;

	@Override
	public JpaRepository<Resource, Integer> getJpaRepository() {
		return resourceRepository;
	}

}
