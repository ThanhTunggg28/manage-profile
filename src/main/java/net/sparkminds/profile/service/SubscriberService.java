package net.sparkminds.profile.service;

import java.util.List;

import net.sparkminds.profile.dto.SubscriberRequestDto;
import net.sparkminds.profile.dto.SubscriberResponseDto;
import net.sparkminds.profile.entity.Subscriber;

public interface SubscriberService {
	SubscriberResponseDto createSubscriber(SubscriberRequestDto subscriberRequestDTO);

	List<Subscriber> getAllSubscriber();

	void updateSubscriber(SubscriberRequestDto subscriberRequestDTO, Long id);

	void deleteSubscriber(Long id);

	List<SubscriberResponseDto> getSubscriberByBrandId(Long brandId);

	List<SubscriberResponseDto> getSubscriberByGender(String sex);
}
