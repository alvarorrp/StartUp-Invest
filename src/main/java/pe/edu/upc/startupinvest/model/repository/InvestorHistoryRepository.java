package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.InvestorHistory;

public interface InvestorHistoryRepository extends JpaRepository<InvestorHistory, Integer> {
	public List<InvestorHistory> list();	
}
