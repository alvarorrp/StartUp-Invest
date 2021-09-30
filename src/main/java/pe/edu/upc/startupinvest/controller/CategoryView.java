package pe.edu.upc.startupinvest.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.service.crud.CategoryService;
import java.util.List;

@Named("categoryView")
@ViewScoped

public class CategoryView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Category> categories;

	@Inject
	private CategoryService categoryService;

	@PostConstruct
	public void init() {
		try {

			categories = categoryService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
