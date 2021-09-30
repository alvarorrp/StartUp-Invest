package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.entities.InvestmentRequest;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.InvestmentRequestRepository;
import pe.edu.upc.startupinvest.service.crud.InvestmentRequestService;

public class InvestmentRequestServiceImpl implements InvestmentRequestService {

	@Inject
	private InvestmentRequestRepository investmentRequestRepository;

	@Override
	public JpaRepository<InvestmentRequest, Integer> getJpaRepository() {
		return investmentRequestRepository;
	}

	@Override
	public List<InvestmentRequest> list() {
		// TODO Auto-generated method stub
		return investmentRequestRepository.list();
	}
	
}
