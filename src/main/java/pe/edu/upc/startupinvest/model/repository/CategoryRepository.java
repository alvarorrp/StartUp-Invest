package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category>findByName(String name) throws Exception;	
	List<Category>findByState (boolean state) throws Exception;
	
	
}
