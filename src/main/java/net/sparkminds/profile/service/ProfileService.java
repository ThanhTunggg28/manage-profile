package net.sparkminds.profile.service;

import java.util.List;

import net.sparkminds.profile.entity.Profile;
import net.sparkminds.profile.dto.ProfileRequestDto;
import net.sparkminds.profile.dto.ProfileResponseDto;

public interface ProfileService {
	ProfileResponseDto createProfile(ProfileRequestDto profileRequestDTO);
	
	List<Profile> getAllProfile();
	
	ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDTO, Long id);

	void deleteProfile(Long id);
}