package pe.edu.upc.startupinvest.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "InvestmentRequests", indexes = {
		@Index(columnList = "investment_request_id", name = "investmentRequests_index_investment_request_id") })
@SequenceGenerator(name = "InvestmentRequest_investment_request_id_seq", initialValue = 1, allocationSize = 1)
public class InvestmentRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvestmentRequest_investment_request_id_seq")
	@Column(name = "investment_request_id", length = 5, nullable = false)
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "startup_id")
	private Startup startup;

	@ManyToOne()
	@JoinColumn(name = "type_investment_id")
	private TypeInvestment typeInvestment;

	@Column(name = "investment_request_amount", columnDefinition = "DECIMAL(12,2)", nullable = false)
	private Double amount;

	@Column(name = "investment_request_state")
	private Boolean state;

	@Column(name = "investment_request_description", length = 200, nullable = false)
	private String description;

	@Column(name = "investment_request_creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(name = "investment_request_expiration_date")
	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	@Column(name = "investment_request_return_date")
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	@OneToMany(mappedBy = "investmentRequest", fetch = FetchType.LAZY)
	private List<InvestorHistory> investorHistories;

	public InvestmentRequest() {
		investorHistories = new ArrayList<InvestorHistory>();
	}

	public InvestmentRequest(Integer id, Startup startup, TypeInvestment typeInvestment, Double amount, Boolean state,
			String description, Date creationDate, Date expirationDate, Date returnDate,
			List<InvestorHistory> investorHistories) {
		super();
		this.id = id;
		this.startup = startup;
		this.typeInvestment = typeInvestment;
		this.amount = amount;
		this.state = state;
		this.description = description;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.returnDate = returnDate;
		this.investorHistories = investorHistories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Startup getStartup() {
		return startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	public TypeInvestment getTypeInvestment() {
		return typeInvestment;
	}

	public void setTypeInvestment(TypeInvestment typeInvestment) {
		this.typeInvestment = typeInvestment;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
