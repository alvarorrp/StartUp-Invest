package pe.edu.upc.startupinvest.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
import pe.edu.upc.startupinvest.service.crud.TypeInvestmentService;

import java.util.ArrayList;
import java.util.List;

@Named("typeInvestmentView")
@ViewScoped

public class TypeInvestmentView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<TypeInvestment> typeInvestments;
	private TypeInvestment typeInvestmentSelected;
	private List<TypeInvestment> typeInvestmentsSelected;
	private TypeInvestment typeInvestmentSearch;

	@Inject
	private TypeInvestmentService typeInvestmentService;

	@PostConstruct
	public void init() {
		typeInvestmentsSelected = new ArrayList<>();
		typeInvestmentSearch = new TypeInvestment();
		getAllTypeInvestment();

	}

	public boolean hasTypeInvestmentsSelected() {
		if (typeInvestmentsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasTypeInvestmentSelected() {
		if (typeInvestmentsSelected.size() == 1) {
			return true;
		}
		return false;
	}

	public void createNewTypeInvestment() {
		typeInvestmentSelected = new TypeInvestment();
	}

	public void editTypeInvestmentSelected() {
		typeInvestmentSelected = typeInvestmentsSelected.get(0);
	}

	public void saveTypeInvestment() {
		try {
			if (typeInvestmentSelected.getId() == null) {
				typeInvestmentService.create(typeInvestmentSelected);
				typeInvestments.add(typeInvestmentSelected);
			} else {
				typeInvestmentService.update(typeInvestmentSelected);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('typeInvestmentDialog').hide()");
		PrimeFaces.current().ajax().update("typeInvestmentDataTable");
	}

	public void deleteTypeInvestment() {
		try {
			this.typeInvestments.remove(typeInvestmentSelected);
			typeInvestmentService.deleteById(this.typeInvestmentSelected.getId());
			this.typeInvestmentSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}

	public void searchTypeInvestment() {
		try {
			typeInvestments = typeInvestmentService.findByName(typeInvestmentSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllTypeInvestment() {
		try {
			typeInvestments = typeInvestmentService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TypeInvestment> getTypeInvestments() {
		return typeInvestments;
	}

	public void setTypeInvestments(List<TypeInvestment> typeInvestments) {
		this.typeInvestments = typeInvestments;
	}

	public TypeInvestment getTypeInvestmentSelected() {
		return typeInvestmentSelected;
	}

	public void setTypeInvestmentSelected(TypeInvestment typeInvestmentSelected) {
		this.typeInvestmentSelected = typeInvestmentSelected;
	}

	public List<TypeInvestment> getTypeInvestmentsSelected() {
		return typeInvestmentsSelected;
	}

	public void setTypeInvestmentsSelected(List<TypeInvestment> typeInvestmentsSelected) {
		this.typeInvestmentsSelected = typeInvestmentsSelected;
	}

	public TypeInvestment getTypeInvestmentSearch() {
		return typeInvestmentSearch;
	}

	public void setTypeInvestmentSearch(TypeInvestment typeInvestmentSearch) {
		this.typeInvestmentSearch = typeInvestmentSearch;
	}

	public TypeInvestmentService getTypeInvestmentService() {
		return typeInvestmentService;
	}

	public void setTypeInvestmentService(TypeInvestmentService typeInvestmentService) {
		this.typeInvestmentService = typeInvestmentService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}