package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface CategoryService extends CrudService<Category, Integer> {

	
	List<Category> findByState(boolean state);
	
	
}
