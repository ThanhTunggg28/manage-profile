package net.sparkminds.profile.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.profile.dto.SubscriberRequestDto;
import net.sparkminds.profile.dto.SubscriberResponseDto;
import net.sparkminds.profile.entity.Brand;
import net.sparkminds.profile.entity.Profile;
import net.sparkminds.profile.entity.Subscriber;
import net.sparkminds.profile.enumeration.Gender;
import net.sparkminds.profile.repository.BrandRepository;
import net.sparkminds.profile.repository.ProfileRepository;
import net.sparkminds.profile.repository.SubscriberRepository;
import net.sparkminds.profile.service.SubscriberService;

@Service
@Transactional(readOnly = true)
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	@Transactional
	public SubscriberResponseDto createSubscriber(SubscriberRequestDto subscriberRequestDTO) {
		Brand brand = brandRepository.findById(subscriberRequestDTO.getBrandId()).orElse(null);
		Profile profile = profileRepository.findById(subscriberRequestDTO.getProfileId()).orElse(null);
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(subscriberRequestDTO.getPhoneNumber());
		subscriber.setBirthDate(subscriberRequestDTO.getDateOfBirth());
		subscriber.setGender(subscriberRequestDTO.getSex());
		subscriber.setBrand(brand);
		subscriber.setProfile(profile);
		subscriberRepository.save(subscriber);
		return SubscriberResponseDto.builder().phoneNumber(subscriber.getPhoneNumber()).brandId(brand.getId())
				.brandName(brand.getName()).profileId(profile.getId()).profileName(profile.getName())
				.birthDate(subscriber.getBirthDate()).gender(subscriber.getGender()).build();
	}

	@Override
	public List<Subscriber> getAllSubscriber() {
		return subscriberRepository.findAll();
	}

	@Override
	public void updateSubscriber(SubscriberRequestDto subscriberRequestDTO, Long id) {

	}

	@Override
	public void deleteSubscriber(Long id) {

	}

	@Override
	public List<SubscriberResponseDto> getSubscriberByBrandId(Long brandId) {
		return subscriberRepository.findByBrandId(brandId).stream().map(entity -> {
			return SubscriberResponseDto.builder()
					.brandName(entity.getBrand().getName())
					.phoneNumber(entity.getPhoneNumber())
					.gender(entity.getGender())
					.brandId(brandId)
					.birthDate(entity.getBirthDate())
					.build();
		}).collect(Collectors.toList());
	}

	@Override
	public List<SubscriberResponseDto> getSubscriberByGender(String sex) {
		return subscriberRepository.findByGender(Gender.valueOf(sex)).stream().map(entity -> {
			return SubscriberResponseDto.builder()
					.brandName(entity.getBrand().getName())
					.phoneNumber(entity.getPhoneNumber())
					.gender(entity.getGender())
					.birthDate(entity.getBirthDate())
					.build();
		}).collect(Collectors.toList());
	}

}