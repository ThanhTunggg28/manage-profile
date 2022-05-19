package net.sparkminds.profile.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.profile.dto.BrandRequestDto;
import net.sparkminds.profile.dto.BrandResponseDto;
import net.sparkminds.profile.entity.Brand;
import net.sparkminds.profile.repository.BrandRepository;
import net.sparkminds.profile.service.BrandService;

@Service
@Transactional(readOnly = true)
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	@Transactional
	public BrandResponseDto createBrand(BrandRequestDto brandRequestDTO) {
		Brand brand = new Brand();
		brand.setName(brandRequestDTO.getName());
		brand.setDescription(brandRequestDTO.getDescription());
		brandRepository.save(brand);
		return BrandResponseDto.builder().name(brand.getName()).description(brand.getDescription())
				.createdBy(brand.getCreatedBy()).createdDate(brand.getCreatedDate()).build();
	}

	@Override
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	@Transactional
	public BrandResponseDto updateBrand(BrandRequestDto brandRequestDTO, Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand is not exist"));

		brand.setName(brandRequestDTO.getName());
		brand.setDescription(brandRequestDTO.getDescription());
		return BrandResponseDto.builder().name(brand.getName()).description(brand.getDescription())
				.createdBy(brand.getCreatedBy()).createdDate(brand.getCreatedDate()).build();
	}

	@Override
	@Transactional
	public void deleteBrand(Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand is not exist"));

		brandRepository.delete(brand);
	}

}