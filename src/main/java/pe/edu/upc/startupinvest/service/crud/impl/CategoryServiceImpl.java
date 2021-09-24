package pe.edu.upc.startupinvest.service.crud.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.model.repository.JpaRepository;
import pe.edu.upc.startupinvest.model.repository.CategoryRepository;
import pe.edu.upc.startupinvest.service.crud.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public JpaRepository<Category, Integer> getJpaRepository() {
		return categoryRepository;
	}

	@Override
	public List<Category> findByCategoryName(String name) {
		return categoryRepository.findByCategoryName(name);
	}
	
	@Override
	public  List<Category> findByState(boolean state) {
		return categoryRepository.findByCategoryState(state);	
	}
	
}
