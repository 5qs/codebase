package com.katana.mongodb.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.katana.UserAccountStatus;
import com.katana.mongodb.domain.KatanaRole;
import com.katana.mongodb.domain.KatanaUser;
import com.katana.mongodb.service.UserService;
import com.katana.web.domain.NewUser;

public class DBUtils {
	
	
	public static void saveUserCredentials (NewUser user,UserService userService, PasswordEncoder encoder)
	{
		KatanaUser kUser = new KatanaUser();
		
		kUser.setUsername(user.getUsername());
		kUser.setPassword(encoder.encode(user.getPassword()));
		
		List<KatanaRole> roleList = new ArrayList<KatanaRole>();
		KatanaRole role = new KatanaRole();
		role.setRole("ROLE_USER");
		role.setRoleDescription("This is a user");
		roleList.add(role);
		kUser.setRoles(roleList);
		userService.create(kUser);
		
		kUser.setEnabled(true);
		kUser.setStatus(UserAccountStatus.STATUS_APPROVED.name());		
		userService.save(kUser);
	}

}
