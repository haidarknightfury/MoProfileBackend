package com.smartfox.moprofile.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.smartfox.moprofile.model.PersonalDetails;
import com.smartfox.moprofile.model.Profile;
import com.smartfox.moprofile.model.Role;
import com.smartfox.moprofile.model.RoleEnum;
import com.smartfox.moprofile.model.WorkDetails;
import com.smartfox.moprofile.repository.ProfileRepository;
import com.smartfox.moprofile.repository.RoleRepository;
import com.smartfox.moprofile.repository.UserRepository;

@Component
public class StartupService implements CommandLineRunner {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		PersonalDetails personalDetails = new PersonalDetails("haidar", "dargaye", "male", "Mr", LocalDate.of(1995, 12, 5));
//		WorkDetails workDetails = new WorkDetails("dso", "", BigInteger.valueOf(25000L));
//		Profile profile = new Profile("hdargaye" ,personalDetails, workDetails);
//		this.profileRepository.save(profile);
//		cleanUp();
//		
//		this.roleRepository.deleteAll();
//		this.roleRepository.saveAll(Arrays.asList(new Role(RoleEnum.ROLE_USER), new Role(RoleEnum.ROLE_ADMIN)));		
//		this.userRepository.deleteAll();
	}
	
	public void cleanUp() {
		this.profileRepository.deleteAll();
	}

}
