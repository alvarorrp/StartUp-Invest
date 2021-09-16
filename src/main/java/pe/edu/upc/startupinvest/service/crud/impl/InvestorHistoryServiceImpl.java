package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.InvestorHistory;
import pe.edu.upc.startupinvest.model.repository.InvestorHistoryRepository;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.service.crud.InvestorHistoryService;

public class InvestorHistoryServiceImpl implements InvestorHistoryService {

	@Inject
	private InvestorHistoryRepository investorHistoryRepository;

	@Override
	public JpaRepository<InvestorHistory, Integer> getJpaRepository() {
		return investorHistoryRepository;
	}

}
