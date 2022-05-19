package net.sparkminds.profile.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Builder;
import lombok.Data;
import net.sparkminds.profile.enumeration.Gender;

@Builder
@Data
public class SubscriberResponseDto {

	private String phoneNumber;
	
	private Date subDate;
	
	private Long brandId;
	
	private String brandName;
	
	private Date birthDate;
	
	private String profileName;
	
	private Long profileId;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
