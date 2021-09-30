package pe.edu.upc.startupinvest.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;


import pe.edu.upc.startupinvest.model.entities.Publication;
import pe.edu.upc.startupinvest.model.entities.Startup;

import pe.edu.upc.startupinvest.service.crud.PublicationService;
import pe.edu.upc.startupinvest.service.crud.StartupService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("publicationView")
@ViewScoped
public class PublicationView implements Serializable {

	private static final long serialVersionUID = 1L;


	private List<Publication> publications;
	private Publication publicationSelected;
	private List<Publication> publicationsSelected;
	private Publication publicationSearch;
	private Date date;
	private String option;
	private Startup startup;
	List<Startup> startups;
	List<SelectItem> selectItemsOneStartup;
	
	@Inject
	private PublicationService publicationService;
	
	@Inject 
	private StartupService startupService;

	@PostConstruct
	public void init() throws Exception {
		publicationsSelected = new ArrayList<>();
		publicationSearch = new Publication();	
		this.startups = new ArrayList<Startup>();
		this.listStartup();
		getAllPublication();

	}
	
	public void listStartup() {
		try {
			startups = startupService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	 void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

	public boolean hasPublicationsSelected() {
		if (publicationsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasPublicationSelected() {
		if (publicationsSelected.size() == 1) {
			return true;
		}
		return false;
	}

	public void createNewPublication() {
		publicationSelected = new Publication();
	}

	public void editPublicationSelected() {
		publicationSelected = publicationsSelected.get(0);
	}

	public void savePublication() {
		try {
			if (publicationSelected.getId() == null) {
				publicationService.create(publicationSelected);
				publications.add(publicationSelected);
			} else {
				publicationService.update(publicationSelected);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('publicationDialog').hide()");
		PrimeFaces.current().ajax().update("publicationDataTable");
	}

	public void deletePublication() {
		try {
			this.publications.remove(publicationSelected);
			publicationService.deleteById(this.publicationSelected.getId());
			this.publicationSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}

	public void searchPublication() {
		try {
			publications = publicationService.findPublicationByName(publicationSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllPublication() {
		try {
			publications = publicationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Startup> getStartups() {
		return startups;
	}

	public void setStartups(List<Startup> startups) {
		this.startups = startups;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication getPublicationSelected() {
		return publicationSelected;
	}

	public void setPublicationSelected(Publication publicationSelected) {
		this.publicationSelected = publicationSelected;
	}

	public List<Publication> getPublicationsSelected() {
		return publicationsSelected;
	}

	public void setPublicationsSelected(List<Publication> publicationsSelected) {
		this.publicationsSelected = publicationsSelected;
	}

	public Publication getPublicationSearch() {
		return publicationSearch;
	}

	public void setPublicationSearch(Publication publicationSearch) {
		this.publicationSearch = publicationSearch;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public StartupService getStartupService() {
		return startupService;
	}

	public void setStartupService(StartupService startupService) {
		this.startupService = startupService;
	}


	public String getOption() {
		return option;
	}


	public void setOption(String option) {
		this.option = option;
	}


	public Startup getStartup() {
		return startup;
	}


	public void setStartup(Startup startup) {
		this.startup = startup;
	}


	public List<SelectItem> getSelectItemsOneStartup() {
		return selectItemsOneStartup;
	}


	public void setSelectItemsOneStartup(List<SelectItem> selectItemsOneStartup) {
		this.selectItemsOneStartup = selectItemsOneStartup;
	}


	
	

}
