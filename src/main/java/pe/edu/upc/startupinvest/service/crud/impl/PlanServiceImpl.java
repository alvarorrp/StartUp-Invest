package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;


import pe.edu.upc.startupinvest.model.entities.Plan;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.PlanRepository;
import pe.edu.upc.startupinvest.service.crud.PlanService;

<<<<<<< Updated upstream
=======
@Named
@ApplicationScoped
>>>>>>> Stashed changes
public class PlanServiceImpl implements PlanService {

	@Inject
	private PlanRepository planRepository;

	@Override
	public JpaRepository<Plan, Integer> getJpaRepository() {
		return planRepository;
	}

}
