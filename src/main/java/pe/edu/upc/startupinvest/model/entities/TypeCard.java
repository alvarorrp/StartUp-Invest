package pe.edu.upc.startupinvest.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "TypeCards",indexes = {@Index(columnList = "type_card_id", name = "typeCards_index_type_card_id"),
		                             @Index(columnList = "type_card_name", name = "typeCards_index_type_card_name") },
                uniqueConstraints = {@UniqueConstraint( columnNames = { "type_card_name" } ) })
@SequenceGenerator(name = "TypeCards_type_card_id_seq", initialValue = 1, allocationSize = 1)
public class TypeCard {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TypeCards_type_card_id_seq")
	@Column(name = "type_card_id", length = 5, nullable = false)
	private Integer id;

	@Column(name="type_card_name",length=50,nullable=false)
	private String name;
	
	@Column(name="type_card_state",nullable=false)
	private Boolean state;
	
	@OneToMany(mappedBy = "typeCard", fetch = FetchType.LAZY)
	private List<InvestorHistory> investorHistories;
	
	@OneToMany(mappedBy = "typeCard", fetch = FetchType.LAZY)
	private List<PlanHistory> plansHistory;
	
	@ManyToMany(mappedBy = "typeCards", fetch = FetchType.EAGER)
	private Set<Investor> investors;

	public TypeCard ()
	{
		 investorHistories=new ArrayList<InvestorHistory>();
		 plansHistory= new ArrayList<PlanHistory>();	 
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

	public List<PlanHistory> getPlansHistory() {
		return plansHistory;
	}

	public void setPlansHistory(List<PlanHistory> plansHistory) {
		this.plansHistory = plansHistory;
	}

	public Set<Investor> getInvestors() {
		return investors;
	}

	public void setInvestors(Set<Investor> investors) {
		this.investors = investors;
	}
	
	
	
}
