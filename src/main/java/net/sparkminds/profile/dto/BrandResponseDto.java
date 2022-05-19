package net.sparkminds.profile.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BrandResponseDto {
private Long id;
	
	private String name;

	private String description;

	private Instant createdDate;
	
	private String createdBy;
	

}