package com.smartfox.moprofile.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartfox.moprofile.model.Role;
import com.smartfox.moprofile.model.RoleEnum;

public interface RoleRepository extends MongoRepository<Role, String> {

	public Optional<Role> findByName(RoleEnum role);
}
