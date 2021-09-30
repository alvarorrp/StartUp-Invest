package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
public interface TypeInvestmentRepository extends JpaRepository<TypeInvestment, Integer> {

	public List<TypeInvestment> list();
	List<TypeInvestment>findByName(String name) throws Exception;	
}
