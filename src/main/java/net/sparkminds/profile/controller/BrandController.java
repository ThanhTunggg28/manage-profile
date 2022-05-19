package net.sparkminds.profile.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.profile.dto.BrandRequestDto;
import net.sparkminds.profile.dto.BrandResponseDto;
import net.sparkminds.profile.entity.Brand;
import net.sparkminds.profile.service.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
	private final BrandService brandService;

	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	
	@GetMapping
	public ResponseEntity<List<Brand>> getBrand(@RequestParam Long brandId) {
		System.out.println(brandId);
		return ResponseEntity.noContent().build();
	};

	@PostMapping
	public ResponseEntity<BrandResponseDto> createCategory(@RequestBody BrandRequestDto brandRequestDTO) {
		
		return ResponseEntity.ok(brandService.createBrand(brandRequestDTO));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Long id, @RequestBody BrandRequestDto brandRequestDTO) {
		brandService.updateBrand(brandRequestDTO, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable("id") Long id) {
		brandService.deleteBrand(id);
		return ResponseEntity.noContent().build();
	}

}
