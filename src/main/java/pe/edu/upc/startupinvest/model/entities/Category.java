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

@Entity
@Table(name = "Categories", indexes = { @Index(columnList = "category_id", name = "categories_index_category_id"),
		@Index(columnList = "category_name", name = "categories_index_category_name") })
@SequenceGenerator(name = "Categories_category_id_seq", initialValue = 1, allocationSize = 1)
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Categories_category_id_seq")
	@Column(name = "category_id", length = 5, nullable = false)
	private Integer id;

	@Column(name = "category_name", length = 40, nullable = false)
	private String name;

	@Column(name = "category_image", length = 500, nullable = true)
	private String image;

	@Column(name = "category_state", nullable = false)
	private boolean state;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Startup> startups;
	

public Category() {
		startups=new ArrayList<Startup>();
	}


public Category(Integer id, String name, String image, boolean state, List<Startup> startups) {
	super();
	this.id = id;
	this.name = name;
	this.image = image;
	this.state = state;
	this.startups = startups;
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


public boolean isState() {
	return state;
}


public void setState(boolean state) {
	this.state = state;
}


public List<Startup> getStartups() {
	return startups;
}


public void setStartups(List<Startup> startups) {
	this.startups = startups;
}

}
