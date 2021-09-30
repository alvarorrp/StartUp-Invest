package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.PlanHistory;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.PlanHistoryRepository;
import pe.edu.upc.startupinvest.service.crud.PlanHistoryService;

public class PlanHistoryServiceImpl implements PlanHistoryService {

	@Inject
	private PlanHistoryRepository planHistoryRepository;

	@Override
	public JpaRepository<PlanHistory, Integer> getJpaRepository() {
		return planHistoryRepository;
	}
	@Override
	public List<PlanHistory> list() {
		// TODO Auto-generated method stub
		return planHistoryRepository.list();
	}
}
