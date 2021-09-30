package pe.edu.upc.startupinvest.model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Publications",indexes= {@Index(columnList = "publication_id", name = "publications_index_publication_id"),
		                               @Index(columnList = "publication_name", name = "publications_index_publication_name")
})
@SequenceGenerator(name = "Publications_publication_id_seq", initialValue = 1, allocationSize = 1)
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Publications_publication_id_seq")
	@Column(name = "publication_id", length = 5, nullable = false)
	private Integer id;

	@Column(name="publication_name",length=100,nullable=false)
	private String name;
	
	@Column(name="publication_date",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="publication_description",length=500,nullable=false)
	private String description;
	
	@ManyToOne()
	@JoinColumn(name = "startup_id", nullable = false)
	private Startup startup;
	
	@Column(name="publication_image",length=500,nullable=true)
	private String image;
	
	@Column(name="publication_url",length=500,nullable=true)
	private String url;

	
public Publication() 
{
	
}
	
	public Publication(Integer id, String name, Date date, String description, Startup startup, String image,
			String url) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.description = description;
		this.startup = startup;
		this.image = image;
		this.url = url;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Startup getStartup() {
		return startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
