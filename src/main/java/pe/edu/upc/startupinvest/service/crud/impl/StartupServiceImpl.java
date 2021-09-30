package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.startupinvest.model.entities.Startup;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.StartupRepository;
import pe.edu.upc.startupinvest.service.crud.StartupService;

@Named
@ApplicationScoped
public class StartupServiceImpl implements StartupService {

	@Inject
	private StartupRepository startupRepository;

	@Override
	public JpaRepository<Startup, Integer> getJpaRepository() {
		return startupRepository;
	}

	@Override
	public Optional<Startup> findById(Integer id) throws Exception {
		return startupRepository.findById(id);
	}
	
	@Override
	public List<Startup> findAll() throws Exception {
		return startupRepository.findAll();
	}
	
	
	@Override
	public List<Startup> findByName(String name) throws Exception{
		return startupRepository.findByName(name);
	}

	@Override
	public List<Startup> findByState(Boolean state) throws Exception {
		return startupRepository.findByState(state);
	}

	@Override
	public List<Startup> findByDateRecently() throws Exception{
		return startupRepository.findByDateRecently();
	}

	@Override
	public List<Startup> findByDateBetween(Date date1, Date date2) throws Exception {
		return startupRepository.findByDateBetween(date1, date2);
	}

	@Override
	public List<Startup> findByPopular() throws Exception{
		return startupRepository.findByPopular();
	}

	@Override
	public List<Startup> list() {
		return startupRepository.list();
	}
	
}
