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
@Table(name = "Resources",indexes= {@Index(columnList = "resource_id", name = "resources_index_resource_id")})
@SequenceGenerator(name = "Resources_resource_id_seq", initialValue = 1, allocationSize = 1)
public class Resource { 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Resources_resource_id_seq")
	@Column(name = "resource_id", length = 5, nullable = false)
	private Integer id;

	@Column(name = "resource_document", length = 5, nullable = false)
	private Byte document;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "startup_id", nullable = false)
	private Startup startup;
	
	@Column(name = "resource_date",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	public Resource() {
		
	}
	
	public Resource(Integer id, Byte document, Startup startup, Date date) {
		super();
		this.id = id;
		this.document = document;
		this.startup = startup;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getDocument() {
		return document;
	}

	public void setDocument(Byte document) {
		this.document = document;
	}

	public Startup getStartup() {
		return startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
