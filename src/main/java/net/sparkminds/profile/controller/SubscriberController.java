package net.sparkminds.profile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.profile.dto.SubscriberRequestDto;
import net.sparkminds.profile.dto.SubscriberResponseDto;
import net.sparkminds.profile.service.SubscriberService;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {
	private final SubscriberService subscriberService;

	public SubscriberController(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}

	@PostMapping
	public ResponseEntity<SubscriberResponseDto> createSubscriber(@RequestBody SubscriberRequestDto subscriberRequestDTO) {
		return ResponseEntity.ok(subscriberService.createSubscriber(subscriberRequestDTO));
	}
}
