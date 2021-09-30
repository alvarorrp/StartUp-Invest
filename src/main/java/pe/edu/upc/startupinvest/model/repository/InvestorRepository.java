package pe.edu.upc.startupinvest.model.repository;

import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Integer> {
	public List<Investor> list();	
}
