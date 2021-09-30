package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.PlanHistory;
public interface PlanHistoryRepository extends JpaRepository<PlanHistory, Integer> {
	public List<PlanHistory> list();	
}
