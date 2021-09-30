package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.startupinvest.model.entities.Plan;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.PlanRepository;
import pe.edu.upc.startupinvest.service.crud.PlanService;
@Named
@ApplicationScoped
public class PlanServiceImpl implements PlanService {

	@Inject
	private PlanRepository planRepository;

	@Override
	public JpaRepository<Plan, Integer> getJpaRepository() {
		return planRepository;
	}

	@Override
	public List<Plan> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return planRepository.findByName(name);
	}

	@Override
	public List<Plan> findAll() throws Exception {
		return planRepository.findAll();
	}
	
	@Override
	public List<Plan> list() {
		// TODO Auto-generated method stub
		return planRepository.list();
	}
	
}
