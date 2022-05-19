package net.sparkminds.profile.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import net.sparkminds.profile.enumeration.Gender;

@Entity
@Table(name="subcriber")
@Getter
@Setter
public class Subscriber {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="phone_number")
	@NotBlank
	private String phoneNumber;
	
	@Column(name="subscribe")
	private Date subcribeDate;
	
	@ManyToOne
	@JoinColumn(name="brand_id", nullable=false)
	private Brand brand;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="gender")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "profile_id", referencedColumnName="id")
    private Profile profile;

	
}
