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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Plans",indexes = { @Index(columnList = "plan_id", name = "plans_index_plan_id"),
		                          @Index(columnList = "plan_name", name = "plans_index_plan_name")},
            uniqueConstraints = { @UniqueConstraint( columnNames = { "plan_name" } ) })
@SequenceGenerator(name = "Plans_monetary_plan_id_seq", initialValue = 1, allocationSize = 1)
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Plans_monetary_plan_id_seq")
	@Column(name = "plan_id", length=5, nullable = false)
	private Integer id;

	@Column(name = "plan_name", length = 40, nullable = false)
	private String name;

	@Column(name = "plan_amount", columnDefinition = "DECIMAL(12,2)", nullable = false)
	private Double amount;

	@OneToMany(mappedBy = "plan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlanHistory> plansHistory;

	public Plan() {
		plansHistory=new ArrayList<PlanHistory>();
	}
	public Plan(Integer id, String name, Double amount, List<PlanHistory> plansHistory) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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

	public List<PlanHistory> getPlansHistory() {
		return plansHistory;
	}

	public void setPlansHistory(List<PlanHistory> plansHistory) {
		this.plansHistory = plansHistory;
	}
	
	
	
}
