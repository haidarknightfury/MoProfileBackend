package com.smartfox.moprofile.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartfox.moprofile.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, BigInteger> {

}
