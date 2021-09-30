package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

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

	@Override
	public List<Resource> list() {
		// TODO Auto-generated method stub
		return resourceRepository.list();
	}
	
}
