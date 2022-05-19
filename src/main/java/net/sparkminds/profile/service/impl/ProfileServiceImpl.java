package net.sparkminds.profile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.profile.dto.ProfileRequestDto;
import net.sparkminds.profile.dto.ProfileResponseDto;
import net.sparkminds.profile.entity.Profile;
import net.sparkminds.profile.repository.ProfileRepository;
import net.sparkminds.profile.service.ProfileService;

@Service
@Transactional(readOnly=true)
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	@Transactional
	public ProfileResponseDto createProfile(ProfileRequestDto profileRequestDTO) {
		Profile profile = new Profile();
		profile.setName(profileRequestDTO.getName());
		profile.setDescription(profileRequestDTO.getDescription());
		profileRepository.save(profile);
		return ProfileResponseDto.builder().name(profile.getName()).description(profile.getDescription())
				.createdBy(profile.getCreatedBy()).createdDate(profile.getCreatedDate()).build();
	}

	@Override
	public List<Profile> getAllProfile() {
		return profileRepository.findAll();
	}

	@Override
	public ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDTO, Long id) {
		
		return null;
	}

	@Override
	public void deleteProfile(Long id) {
		
		
	}

}