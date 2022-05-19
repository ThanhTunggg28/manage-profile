package net.sparkminds.profile.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.profile.entity.Profile;
import net.sparkminds.profile.service.ProfileService;
import net.sparkminds.profile.dto.ProfileRequestDto;
import net.sparkminds.profile.dto.ProfileResponseDto;

@RestController
@RequestMapping("api/profiles")
public class ProfileController {
	private final ProfileService profileService;

	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@GetMapping
	public ResponseEntity<List<Profile>> getProfile() {
		return ResponseEntity.ok().body(profileService.getAllProfile());
	};

	@PostMapping
	public ResponseEntity<ProfileResponseDto> createProfile(@RequestBody ProfileRequestDto profileRequestDto) {
		return ResponseEntity.ok(profileService.createProfile(profileRequestDto));
	}
}
