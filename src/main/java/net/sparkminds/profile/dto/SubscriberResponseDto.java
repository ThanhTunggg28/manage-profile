package net.sparkminds.profile.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Builder;
import lombok.Data;
import net.sparkminds.profile.enumeration.SubcriberSex;

@Builder
@Data
public class SubscriberResponseDto {

	private String phoneNumber;
	
	private Date subDate;
	
	private Long brandId;
	
	private String brandName;
	
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private SubcriberSex sex;
}
