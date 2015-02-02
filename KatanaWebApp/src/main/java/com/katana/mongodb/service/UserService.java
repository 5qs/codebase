package com.katana.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.katana.UserAccountStatus;
import com.katana.mongodb.domain.KatanaUser;
import com.katana.mongodb.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired private UserRepository userRepository;
	
	
	public boolean create(KatanaUser user) {
		Assert.isNull(user.getId());

		// duplicate username
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return false;
		}
		user.setEnabled(false);
		user.setStatus(UserAccountStatus.STATUS_DISABLED.name());
		userRepository.save(user);
		return true;
	}
	
	public void save(KatanaUser user) {
		Assert.notNull(user.getId());
		userRepository.save(user);
	}
	
	public void delete(KatanaUser user) {
		Assert.notNull(user.getId());
		userRepository.delete(user);
	}
	
	public KatanaUser getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	

}
