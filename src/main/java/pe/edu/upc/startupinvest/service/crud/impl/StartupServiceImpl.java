package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.Date;
import java.util.List;

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

	@Override
	public List<Startup> findByName(String name) {
		return startupRepository.findByName(name);
	}

	@Override
	public List<Startup> findByState(Boolean state) {
		return startupRepository.findByState(state);
	}

	@Override
	public List<Startup> findByDateRecently() {
		return startupRepository.findByDateRecently();
	}

	@Override
	public List<Startup> findByDateBetween(Date date1, Date date2) {
		return startupRepository.findByDateBetween(date1, date2);
	}

	@Override
	public List<Startup> findByPopular() {
		return startupRepository.findByPopular();
	}
	
}
