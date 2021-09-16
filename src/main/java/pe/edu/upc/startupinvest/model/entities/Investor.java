package pe.edu.upc.startupinvest.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "Investors", indexes = { @Index(columnList = "investor_id", name = "investors_index_investor_id") })
@SequenceGenerator(name = "Investors_investor_id_seq", initialValue = 1, allocationSize = 1)
public class Investor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Investors_investor_id_seq")
	@Column(name = "investor_id", length = 5, nullable = false)
	private Integer id;

	@Column(name = "investor_name", length = 50, nullable = false)
	private String name;

	@Column(name = "investor_image", length = 500, nullable = false)
	private String image;

	@Column(name = "investor_state", nullable = false)
	private Boolean state;

	@OneToMany(mappedBy = "investor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<InvestorHistory> investorHistories;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "TypeCardDetails", joinColumns = {
			@JoinColumn(referencedColumnName = "investor_id", name = "investor_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "type_card_id", name = "type_card_id") })
	private Set<TypeCard> typeCards;

	
	public Investor() {
		investorHistories= new ArrayList<InvestorHistory>();
		
	}
	
	
	public Investor(Integer id, String name, String image, Boolean state, List<InvestorHistory> investorHistories,
			Set<TypeCard> typeCards) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.state = state;
		this.investorHistories = investorHistories;
		this.typeCards = typeCards;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Boolean getState() {
		return state;
	}


	public void setState(Boolean state) {
		this.state = state;
	}


	public List<InvestorHistory> getInvestorHistories() {
		return investorHistories;
	}


	public void setInvestorHistories(List<InvestorHistory> investorHistories) {
		this.investorHistories = investorHistories;
	}


	public Set<TypeCard> getTypeCards() {
		return typeCards;
	}


	public void setTypeCards(Set<TypeCard> typeCards) {
		this.typeCards = typeCards;
	}
}
