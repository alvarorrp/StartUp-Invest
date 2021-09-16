package pe.edu.upc.startupinvest.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "MonetaryUnits",indexes = {@Index(columnList = "monetary_unit_name", name = "monetaryUnits_index_monetary_unit_name"),
		                                 @Index(columnList = "monetary_unit_id", name = "monetaryUnits_index_monetary_unit_id")},
                    uniqueConstraints = {@UniqueConstraint( columnNames = { "monetary_unit_name" } ) })
@SequenceGenerator(name = "MonetaryUnits_monetary_unit_id_seq", initialValue = 1, allocationSize = 1)
public class MonetaryUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MonetaryUnits_monetary_unit_id_seq")
	@Column(name = "monetary_unit_id", length=5, nullable = false)
	private Integer id;

	@Column(name = "monetary_unit_name", length = 40, nullable = false)
	private String name;

	@Column(name = "monetary_unit_image", length = 500, nullable = false)
	private String image;

	@Column(name = "monetary_unit_state",nullable = false)
	private Boolean state;

	@OneToMany(mappedBy = "monetaryUnit", fetch = FetchType.LAZY)
	private List<InvestmentRequest>investmentRequests ;
	
	@OneToMany(mappedBy = "monetaryUnit", fetch = FetchType.LAZY)
	private List<Plan>plans ;
	
	public MonetaryUnit() {
		investmentRequests=new ArrayList<InvestmentRequest>();
		plans=new ArrayList<Plan>();
	}

	public MonetaryUnit(Integer id, String name, String image, Boolean state,
			List<InvestmentRequest> investmentRequests, List<Plan> plans) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.state = state;
		this.investmentRequests = investmentRequests;
		this.plans = plans;
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

	public List<InvestmentRequest> getInvestmentRequests() {
		return investmentRequests;
	}

	public void setInvestmentRequests(List<InvestmentRequest> investmentRequests) {
		this.investmentRequests = investmentRequests;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	
}
