package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Resource;
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
	public List<Resource> list();	
}
