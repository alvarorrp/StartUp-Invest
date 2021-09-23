package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category>findByCategoryName(String name);	
	List<Category>findByCategoryState (boolean state);
	
	
}
