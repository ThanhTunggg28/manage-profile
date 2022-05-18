package net.sparkminds.profile.service;

import java.util.List;

import net.sparkminds.profile.dto.BrandRequestDto;
import net.sparkminds.profile.entity.Brand;

public interface BrandService {
	Brand createBrand(BrandRequestDto brandRequestDTO);
	
	List<Brand> getAllBrand();
	
	void updateBrand(BrandRequestDto brandRequestDTO, Long id);

	void deleteBrand(Long id);
	
	List<Brand> searchBrand(String keyword);
}
