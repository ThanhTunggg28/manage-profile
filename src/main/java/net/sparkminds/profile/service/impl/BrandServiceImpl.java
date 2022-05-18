package net.sparkminds.profile.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.profile.dto.BrandRequestDto;
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
	public Brand createBrand(BrandRequestDto brandRequestDto) {
		// TODO Auto-generated method stub
		Date currentDate = new Date();
		Brand brand = new Brand();
		brand.setName(brandRequestDto.getName());
		brand.setDescription(brandRequestDto.getDescription());
		brand.setCreatedBy(brandRequestDto.getCreatedBy());
		brand.setCreatedDate(currentDate);
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	@Transactional
	public void updateBrand(BrandRequestDto brandRequestDTO, Long id) {
		Date currentDate = new Date();
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand is not exist"));

		brand.setName(brandRequestDTO.getName());
		brand.setDescription(brandRequestDTO.getDescription());
		brand.setCreatedBy(brandRequestDTO.getCreatedBy());
		brand.setUpdatedDate(currentDate);
	}

	@Override
	@Transactional
	public void deleteBrand(Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand is not exist"));

		brandRepository.delete(brand);

	}

	@Override
	public List<Brand> searchBrand(String keyword) {
		return null;
		
	}

}
