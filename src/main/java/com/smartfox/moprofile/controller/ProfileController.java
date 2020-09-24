package com.smartfox.moprofile.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.moprofile.model.Profile;
import com.smartfox.moprofile.repository.ProfileRepository;


@CrossOrigin
@RestController(value = "profileController")
@RequestMapping(path = "/profile")
public class ProfileController {
	
	private ProfileRepository profileRepository;
	
	public ProfileController(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}
	
	@PostMapping
	public Profile updateProfile(@RequestBody Profile profile) {	
		System.out.println(profile);
		Objects.requireNonNull(profile.getPersonal().getGender(), "gender should not be null");
		return this.profileRepository.save(profile);
	}
	
	
	@GetMapping
	public List<Profile> getAllProfiles(){
		return this.profileRepository.findAll();
	}

}
