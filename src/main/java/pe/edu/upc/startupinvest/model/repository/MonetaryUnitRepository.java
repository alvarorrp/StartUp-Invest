package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.MonetaryUnit;
public interface MonetaryUnitRepository extends JpaRepository<MonetaryUnit, Integer> {
List<MonetaryUnit>findMonetaryUnitByName (String name);
}
