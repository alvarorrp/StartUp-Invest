package pe.edu.upc.startupinvest.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TypesInvestment",indexes= {@Index(columnList = "type_investment_id", name = "typesInvestment_index_type_investment_id")})
@SequenceGenerator(name = "TypesInvestment_type_investment_id_seq", initialValue = 1, allocationSize = 1)
public class TypeInvestment {
	@Id
	@Column(name = "type_investment_id", length = 5, nullable = false)
	private Integer id;
	
	@Column(name="type_investment_name",length=50,nullable=false)
	private String name;
	
	@Column(name="type_investment_description",length=50,nullable=false)
	private String description;
	
	@OneToMany(mappedBy = "typeInvestment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<InvestmentRequest> investmentRequests;

	
	public TypeInvestment()	{
	
	investmentRequests=new ArrayList<InvestmentRequest>();
	}
	
	
	public TypeInvestment(Integer id, String name, String description, List<InvestmentRequest> investmentRequests) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.investmentRequests = investmentRequests;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<InvestmentRequest> getInvestmentRequests() {
		return investmentRequests;
	}

	public void setInvestmentRequests(List<InvestmentRequest> investmentRequests) {
		this.investmentRequests = investmentRequests;
	}
	
	
}
