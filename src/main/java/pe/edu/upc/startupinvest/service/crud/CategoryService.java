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
	
	Optional<Category> findById(Integer id) throws Exception;
	List<Category> findAll() throws Exception;
	List<Category> findByName(String name) throws Exception;
	List<Category> findByState(boolean state) throws Exception;
	
}
