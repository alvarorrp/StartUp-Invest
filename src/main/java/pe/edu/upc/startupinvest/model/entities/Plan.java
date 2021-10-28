package pe.edu.upc.startupinvest.model.entities;

import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Plans",indexes = { @Index(columnList = "plan_id", name = "plans_index_plan_id"),
		                          @Index(columnList = "plan_name", name = "plans_index_plan_name")},
            uniqueConstraints = { @UniqueConstraint( columnNames = { "plan_name" } ) })
<<<<<<< Updated upstream
@SequenceGenerator(name = "Plans_monetary_plan_id_seq", initialValue = 1, allocationSize = 1)
=======
//@SequenceGenerator(name = "Plans_monetary_plan_id_seq", initialValue = 100, allocationSize = 1)
>>>>>>> Stashed changes
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_id", length=5, nullable = false)
	private Integer id;

	@Column(name = "plan_name", length = 40, nullable = false)
	private String name;

	@Column(name = "plan_amount", columnDefinition = "DECIMAL(12,2)", nullable = false)
	private Double amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "monetary_unit_id", nullable = false)
	private MonetaryUnit monetaryUnit;

	@OneToMany(mappedBy = "plan", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<PlanHistory> plansHistory;

	
	public Plan() {
		plansHistory=new ArrayList<PlanHistory>();
	}
	public Plan(Integer id, String name, Double amount, MonetaryUnit monetaryUnit, List<PlanHistory> plansHistory) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.monetaryUnit = monetaryUnit;
		this.plansHistory = plansHistory;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public MonetaryUnit getMonetaryUnit() {
		return monetaryUnit;
	}

	public void setMonetaryUnit(MonetaryUnit monetaryUnit) {
		this.monetaryUnit = monetaryUnit;
	}

	public List<PlanHistory> getPlansHistory() {
		return plansHistory;
	}

	public void setPlansHistory(List<PlanHistory> plansHistory) {
		this.plansHistory = plansHistory;
	}
	
	
	
}
