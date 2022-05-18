package net.sparkminds.profile.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.profile.dto.SubscriberRequestDto;
import net.sparkminds.profile.dto.SubscriberResponseDto;
import net.sparkminds.profile.entity.Brand;
import net.sparkminds.profile.entity.Subscriber;
import net.sparkminds.profile.repository.BrandRepository;
import net.sparkminds.profile.repository.SubscriberRepository;
import net.sparkminds.profile.service.SubscriberService;

@Service
@Transactional(readOnly = true)
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Override
	@Transactional
	public SubscriberResponseDto createSubscriber(SubscriberRequestDto subscriberRequestDTO) {

		Brand brand = brandRepository.findById(subscriberRequestDTO.getBrandId()).orElse(null);
		Date currentDate = new Date();	
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(subscriberRequestDTO.getPhoneNumber());
		subscriber.setBirthDate(subscriberRequestDTO.getDateOfBirth());
		subscriber.setSex(subscriberRequestDTO.getSex());
		subscriber.setSubcribeDate(currentDate);
		subscriber.setBrand(brand);
		subscriberRepository.save(subscriber);
		return SubscriberResponseDto.builder()
				.phoneNumber(subscriber.getPhoneNumber())
				.subDate(subscriber.getSubcribeDate())
				.brandId(brand.getId())
				.brandName(brand.getName())
				.dateOfBirth(subscriber.getBirthDate())
				.sex(subscriber.getSex())
				.build();
	}

	@Override
	public List<Subscriber> getAllSubscriber() {
		return null;
	}

	@Override
	public void updateSubscriber(SubscriberRequestDto subscriberRequestDTO, Long id) {

	}

	@Override
	public void deleteSubscriber(Long id) {

	}

}
