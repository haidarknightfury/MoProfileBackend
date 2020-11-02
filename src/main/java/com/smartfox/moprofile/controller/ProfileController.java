package com.smartfox.moprofile.controller;

import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.moprofile.config.MoProfileUser;
import com.smartfox.moprofile.mapper.ProfileMapper;
import com.smartfox.moprofile.model.PersonalDetails;
import com.smartfox.moprofile.model.Profile;
import com.smartfox.moprofile.model.WorkDetails;
import com.smartfox.moprofile.repository.ProfileRepository;


@CrossOrigin
@RestController(value = "profileController")
@RequestMapping(path = "/profile")
public class ProfileController {
	
	private ProfileRepository profileRepository;
	private ProfileMapper profileMapper;
	private Logger LOG = LoggerFactory.getLogger(ProfileController.class);
	
	public ProfileController(ProfileRepository profileRepository, ProfileMapper profileMapper) {
		this.profileRepository = profileRepository;
		this.profileMapper = profileMapper;
	}
	
	@PostMapping
	public Profile updateProfile(@RequestBody Profile profile) {	
		LOG.info("profile update of {} ",profile.getUsername());
		profile = profileMapper.ProfileUserMapper.apply(profile);
		Objects.requireNonNull(profile.getPersonal().getGender(), "gender should not be null");
		return this.profileRepository.save(profile);
	}
	
	
	@GetMapping
	public Profile getProfile(){
		LOG.info("get profile from db");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((MoProfileUser) authentication.getPrincipal()).getUsername();
		LOG.info("{} getting profile",username);
		Optional<Profile> profile = this.profileRepository.findByUsername(username);
		return profile.orElse(getNewProfile(username));
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAllProfiles() {
		this.profileRepository.deleteAll();
		return ResponseEntity.ok(null);
	}
	
	private Profile getNewProfile(String username) {
		return new Profile(username, new PersonalDetails(), new WorkDetails());
	}

}
