package com.smartfox.moprofile.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartfox.moprofile.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, BigInteger> {
	
	Optional<Profile>findByUsername(String username);

}
