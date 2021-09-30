package pe.edu.upc.startupinvest.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.startupinvest.model.entities.TypeCard;

import pe.edu.upc.startupinvest.service.crud.TypeCardService;

import java.util.ArrayList;
import java.util.List;

@Named("typeCardView")
@ViewScoped

public class TypeCardView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<TypeCard> typeCards;
	private TypeCard typeCardSelected;
	private List<TypeCard> typeCardsSelected;
	private TypeCard typeCardSearch;

	@Inject
	private TypeCardService typeCardService;

	@PostConstruct
	public void init() {
		typeCardsSelected = new ArrayList<>();
		typeCardSearch = new TypeCard();
		getAllTypeCard();

	}

	public boolean hasTypeCardsSelected() {
		if (typeCardsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasTypeCardSelected() {
		if (typeCardsSelected.size() == 1) {
			return true;
		}
		return false;
	}

	public void createNewTypeCard() {
		typeCardSelected = new TypeCard();
	}

	public void editTypeCardSelected() {
		typeCardSelected = typeCardsSelected.get(0);
	}

	public void saveTypeCard() {
		try {
			if (typeCardSelected.getId() == null) {
				typeCardService.create(typeCardSelected);
				typeCards.add(typeCardSelected);
			} else {
				typeCardService.update(typeCardSelected);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('typeCardDialog').hide()");
		PrimeFaces.current().ajax().update("typeCardDataTable");
	}

	public void deleteTypeCard() {
		try {
			this.typeCards.remove(typeCardSelected);
			typeCardService.deleteById(this.typeCardSelected.getId());
			this.typeCardSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}

	public void searchTypeCard() {
		try {
			typeCards = typeCardService.findTypeCardByName(typeCardSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllTypeCard() {
		try {
			typeCards = typeCardService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TypeCard> getTypeCards() {
		return typeCards;
	}

	public void setTypeCards(List<TypeCard> typeCards) {
		this.typeCards = typeCards;
	}

	public TypeCard getTypeCardSelected() {
		return typeCardSelected;
	}

	public void setTypeCardSelected(TypeCard typeCardSelected) {
		this.typeCardSelected = typeCardSelected;
	}

	public List<TypeCard> getTypeCardsSelected() {
		return typeCardsSelected;
	}

	public void setTypeCardsSelected(List<TypeCard> typeCardsSelected) {
		this.typeCardsSelected = typeCardsSelected;
	}

	public TypeCard getTypeCardSearch() {
		return typeCardSearch;
	}

	public void setTypeCardSearch(TypeCard typeCardSearch) {
		this.typeCardSearch = typeCardSearch;
	}

	public TypeCardService getTypeCardService() {
		return typeCardService;
	}

	public void setTypeCardService(TypeCardService typeCardService) {
		this.typeCardService = typeCardService;
	}

}
