package pe.edu.upc.startupinvest.service.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.MonetaryUnit;
import pe.edu.upc.startupinvest.model.repository.MonetaryUnitRepository;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.service.crud.MonetaryUnitService;

public class MonetaryUnitServiceImpl implements MonetaryUnitService {

	@Inject
	private MonetaryUnitRepository monetaryUnitRepository;

	@Override
	public JpaRepository<MonetaryUnit, Integer> getJpaRepository() {
		return monetaryUnitRepository;
	}

}
