package pe.edu.upc.startupinvest.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.startupinvest.model.entities.Category;
import pe.edu.upc.startupinvest.service.crud.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Named("categoryView")
@ViewScoped

public class CategoryView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Category> categories;
	private Category categorySelected;
	private List<Category> categoriesSelected;
	private Category categorySearch;

	@Inject
	private CategoryService categoryService;

	@PostConstruct
	public void init() {
		categoriesSelected = new ArrayList<>();
		categorySearch = new Category();
		getAllCategory();

	}

	public boolean hasCategoriesSelected() {
		if (categoriesSelected.isEmpty()) {
			return false;
		}
		return true;
	}


	public boolean hasCategorieSelected() {
		if (categoriesSelected.isEmpty()) {
            return false;
        }
        return true;
	}

	
	public boolean hasCategorySelected() {

		if (categoriesSelected.size() == 1) {
			return true;
		}
		return false;
	}

	public void createNewCategory() {
		categorySelected = new Category();
	}

	public void editCategorySelected() {
		categorySelected = categoriesSelected.get(0);
	}

	public void saveCategory() {
		try {
			if (categorySelected.getId() == null) {
				categoryService.create(categorySelected);
				categories.add(categorySelected);
			} else {
				categoryService.update(categorySelected);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('categoryDialog').hide()");
		PrimeFaces.current().ajax().update("categoryDataTable");
	}

	public void deleteCategory() {
		try {
			this.categories.remove(categorySelected);
			categoryService.deleteById(this.categorySelected.getId());
			this.categorySelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}

	public void searchCategory() {
		try {
			categories = categoryService.findByName(categorySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllCategory() {
		try {
			categories = categoryService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategorySelected() {
		return categorySelected;
	}

	public void setCategorySelected(Category categorySelected) {
		this.categorySelected = categorySelected;
	}

	public List<Category> getCategoriesSelected() {
		return categoriesSelected;
	}

	public void setCategoriesSelected(List<Category> categoriesSelected) {
		this.categoriesSelected = categoriesSelected;
	}

	public Category getCategorySearch() {
		return categorySearch;
	}

	public void setCategorySearch(Category categorySearch) {
		this.categorySearch = categorySearch;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
