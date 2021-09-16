package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.TypeInvestmentRepository;
import pe.edu.upc.startupinvest.service.crud.TypeInvestmentService;

public class TypeInvestmentServiceImpl implements TypeInvestmentService {

	@Inject
	private TypeInvestmentRepository typeInvestmentRepository;

	@Override
	public JpaRepository<TypeInvestment, Integer> getJpaRepository() {
		return typeInvestmentRepository;
	}

}
