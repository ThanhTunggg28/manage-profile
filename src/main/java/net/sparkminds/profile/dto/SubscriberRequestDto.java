package net.sparkminds.profile.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.Setter;
import net.sparkminds.profile.entity.Brand;
import net.sparkminds.profile.enumeration.SubcriberSex;

@Data
@Setter
public class SubscriberRequestDto {

	private String phoneNumber;
	
	private Date subDate;
	
	private Brand brand;
	
	private Long brandId;
	
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private SubcriberSex sex;

	
	
	
	
}
