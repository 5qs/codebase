package com.katana.mongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.katana.mongodb.domain.KatanaUser;

public interface UserRepository extends MongoRepository<KatanaUser, String> {
	
	KatanaUser findByUsername(final String username);
	List<KatanaUser> findByUsernameAndPassword(final String username, final String password);
	List<KatanaUser> findByPasswordAndUsername(final String password, final String username);
	List<KatanaUser> findByUsernameLike(final String username);
	@Query("{ 'username' : ?0, 'password' : ?1 }")
	List<KatanaUser> findByUsernameAndPasswordQuery(final String username, final String password);
}
