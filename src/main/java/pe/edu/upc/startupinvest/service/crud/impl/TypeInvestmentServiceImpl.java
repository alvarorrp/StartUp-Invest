package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.TypeInvestmentRepository;
import pe.edu.upc.startupinvest.service.crud.TypeInvestmentService;
@Named
@ApplicationScoped
public class TypeInvestmentServiceImpl implements TypeInvestmentService {

	@Inject
	private TypeInvestmentRepository typeInvestmentRepository;

	@Override
	public JpaRepository<TypeInvestment, Integer> getJpaRepository() {
		return typeInvestmentRepository;
	}

	@Override
	public List<TypeInvestment> list() {
		// TODO Auto-generated method stub
		return typeInvestmentRepository.list();
	}
	
	@Override
	public List<TypeInvestment> findByName(String name) throws Exception{
		return typeInvestmentRepository.findByName(name);
	}
	
}
