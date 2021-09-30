package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.Investor;
import pe.edu.upc.startupinvest.model.repository.InvestorRepository;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.service.crud.InvestorService;

public class InvestorServiceImpl implements InvestorService {

	@Inject
	private InvestorRepository investorRepository;

	@Override
	public JpaRepository<Investor, Integer> getJpaRepository() {
		return investorRepository;
	}

	@Override
	public List<Investor> list() {
		// TODO Auto-generated method stub
		return investorRepository.list();
	}
	
}
