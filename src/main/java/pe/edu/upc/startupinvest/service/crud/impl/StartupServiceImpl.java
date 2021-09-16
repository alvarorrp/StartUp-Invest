package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.Startup;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.StartupRepository;
import pe.edu.upc.startupinvest.service.crud.StartupService;

public class StartupServiceImpl implements StartupService {

	@Inject
	private StartupRepository startupRepository;

	@Override
	public JpaRepository<Startup, Integer> getJpaRepository() {
		return startupRepository;
	}

}
