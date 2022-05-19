package net.sparkminds.profile.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.profile.dto.SubscriberRequestDto;
import net.sparkminds.profile.dto.SubscriberResponseDto;
import net.sparkminds.profile.entity.Subscriber;
import net.sparkminds.profile.service.SubscriberService;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {
	private final SubscriberService subscriberService;

	public SubscriberController(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}

	@GetMapping
	public ResponseEntity<List<Subscriber>> getSubscriber() {
		return ResponseEntity.ok().body(subscriberService.getAllSubscriber());
	};
	@GetMapping(value="/brand")
	public ResponseEntity<List<SubscriberResponseDto>> getSubByBrandId(@RequestParam Long brandId) {
		return ResponseEntity.ok().body(subscriberService.getSubscriberByBrandId(brandId));
	};
	@GetMapping(value="/gender")
	public ResponseEntity<List<SubscriberResponseDto>> getSubByGender(@RequestParam String sex) {
		return ResponseEntity.ok().body(subscriberService.getSubscriberByGender(sex));
	};
	@PostMapping
	public ResponseEntity<SubscriberResponseDto> createSubscriber(@RequestBody SubscriberRequestDto subscriberRequestDTO) {
		return ResponseEntity.ok(subscriberService.createSubscriber(subscriberRequestDTO));
	}
}
