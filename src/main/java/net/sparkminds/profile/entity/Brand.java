package net.sparkminds.profile.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="brand")
public class Brand {
	
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "update_by")
	private Date updatedDate;
	
	
	@OneToMany(mappedBy="brand")
	private List<Subscriber> subcribers;
	

	@PrePersist
	public void onSave() {
		Date currentDate = new Date();

		this.createdDate = currentDate;
		this.updatedDate = currentDate;
	}
	
	@PostPersist
	public void onUpdate() {
		Date currentDate = new Date();
		this.updatedDate = currentDate;
	}

}
