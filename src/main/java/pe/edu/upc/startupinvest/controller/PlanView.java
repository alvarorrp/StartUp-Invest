package pe.edu.upc.startupinvest.controller;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import pe.edu.upc.startupinvest.model.entities.Plan;
import pe.edu.upc.startupinvest.service.crud.PlanService;

import java.util.ArrayList;
import java.util.List;


@Named("planView")
@ViewScoped
public class PlanView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Plan> plans;
	private Plan planSelected;
	private List<Plan> plansSelected;
	private Plan planSearch;

	@Inject
	private PlanService planService;

	@PostConstruct
	public void init() {
		plansSelected = new ArrayList<>();
		planSearch = new Plan();
		getAllPlan();

	}

	public boolean hasPlansSelected() {
		if (plansSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasPlanSelected() {
		if (plansSelected.size() == 1) {
			return true;
		}
		return false;
	}

	public void createNewPlan() {
		planSelected = new Plan();
	}

	public void editPlanSelected() {
		planSelected = plansSelected.get(0);
	}

	public void savePlan() {
		try {
			if (planSelected.getId() == null) {
				planService.create(planSelected);
				plans.add(planSelected);
			} else {
				planService.update(planSelected);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('planDialog').hide()");
		PrimeFaces.current().ajax().update("planDataTable");
	}

	public void deletePlan() {
		try {
			this.plans.remove(planSelected);
			planService.deleteById(this.planSelected.getId());
			this.planSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}

	public void searchPlan() {
		try {
			plans = planService.findByName(planSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllPlan() {
		try {
			plans = planService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public Plan getPlanSelected() {
		return planSelected;
	}

	public void setPlanSelected(Plan planSelected) {
		this.planSelected = planSelected;
	}

	public List<Plan> getPlansSelected() {
		return plansSelected;
	}

	public void setPlansSelected(List<Plan> plansSelected) {
		this.plansSelected = plansSelected;
	}

	public Plan getPlanSearch() {
		return planSearch;
	}

	public void setPlanSearch(Plan planSearch) {
		this.planSearch = planSearch;
	}

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
