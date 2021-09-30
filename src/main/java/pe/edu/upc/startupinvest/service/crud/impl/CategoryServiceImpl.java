package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.CategoryRepository;
import pe.edu.upc.startupinvest.service.crud.CategoryService;

@Named
@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public JpaRepository<Category, Integer> getJpaRepository() {
		return categoryRepository;
	}

	
	@Override
	public Optional<Category> findById(Integer id) throws Exception {
		return categoryRepository.findById(id);
	}
	
	@Override
	public List<Category> findAll() throws Exception {
		return categoryRepository.findAll();
	}
	
	
	@Override
	public List<Category> findByName(String name) throws Exception{
		return categoryRepository.findByName(name);
	}
	
	@Override
	public  List<Category> findByState(boolean state) throws Exception {
		return categoryRepository.findByState(state) ;	
	}


	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryRepository.list();
	}
	
}
