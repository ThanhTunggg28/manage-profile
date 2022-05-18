package net.sparkminds.profile.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BrandRequestDto {
	private String name;
	private String description;
	private String createdBy;
	private Date createdDate;
	private Date lastUpdated;
	
	
	
	
}
