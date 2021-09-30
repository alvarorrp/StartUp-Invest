package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Plan;
public interface PlanRepository extends JpaRepository<Plan, Integer> {
List<Plan>findPlanByName (String name);
}
