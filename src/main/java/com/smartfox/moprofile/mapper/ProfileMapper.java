package com.smartfox.moprofile.mapper;

import java.util.function.Function;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.smartfox.moprofile.config.MoProfileUser;
import com.smartfox.moprofile.dto.PersonalDetailsDTO;
import com.smartfox.moprofile.dto.ProfileDTO;
import com.smartfox.moprofile.dto.WorkDetailsDTO;
import com.smartfox.moprofile.model.PersonalDetails;
import com.smartfox.moprofile.model.Profile;
import com.smartfox.moprofile.model.WorkDetails;

@Component
public class ProfileMapper {

					
	public  Function<Profile, Profile> ProfileUserMapper = (profile)->{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		profile.setUsername(((MoProfileUser) authentication.getPrincipal()).getUsername());
		return profile;
	};
	
	public Function <PersonalDetails, PersonalDetailsDTO> PersonalDetailsDTOMapper = (personal) ->{
		return new PersonalDetailsDTO(personal.getFirstName(), 
				                      personal.getLastName(), 
				                      personal.getTitle(), 
				                      personal.getGender(), 
				                      personal.getDateOfBirth());
	};
	
	
	public Function <WorkDetails, WorkDetailsDTO> WorkDTOMapper = (work) ->{
		return new WorkDetailsDTO(work.getCompany(),
				                  work.getDateOfEmployment(),
				                  work.getSalary());
	};
	
	
	public Function <Profile, ProfileDTO>  ProfileProfileDTOMapper = (profile) ->{
		return new ProfileDTO(profile.getUsername(), 
				              PersonalDetailsDTOMapper.apply(profile.getPersonal()),
				              WorkDTOMapper.apply(profile.getWork())
				             );
	};
	

	
}									
