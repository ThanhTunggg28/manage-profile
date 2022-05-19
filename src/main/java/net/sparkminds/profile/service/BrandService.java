package net.sparkminds.profile.service;

import java.util.List;

import net.sparkminds.profile.dto.BrandRequestDto;
import net.sparkminds.profile.dto.BrandResponseDto;
import net.sparkminds.profile.entity.Brand;

public interface BrandService {
	BrandResponseDto createBrand(BrandRequestDto brandRequestDTO);

	List<Brand> getAllBrand();

	BrandResponseDto updateBrand(BrandRequestDto brandRequestDTO, Long id);

	void deleteBrand(Long id);
}
