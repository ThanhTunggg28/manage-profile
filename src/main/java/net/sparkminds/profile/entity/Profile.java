package net.sparkminds.profile.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="profile")
public class Profile {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;
	
	@CreatedDate
	@Column(name = "created_date")
	protected Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@Column(name = "update_by")
	protected Instant updatedDate = Instant.now();
	
	

	

}
