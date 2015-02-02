package com.katana.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.katana.mongodb.domain.KatanaRole;
import com.katana.mongodb.domain.KatanaUser;
import com.katana.mongodb.service.UserService;

@Component
public class LocalAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	 @Autowired private PasswordEncoder encoder;
	 @Autowired UserService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		
		String password = (String) authentication.getCredentials();
        if (!StringUtils.hasText(password)) {
        	//logger.warn("Username {}: no password provided", username);
            throw new BadCredentialsException("Please enter password");
        }

        KatanaUser user = userService.getByUsername(username);
        if (user == null) {
        	//logger.warn("Username {} password {}: user not found", username, password);
            throw new UsernameNotFoundException("Invalid Login");
        }
        
        if (!encoder.matches(password, user.getPassword())) {
        	//logger.warn("Username {} password {}: invalid password", username, password);
            throw new BadCredentialsException("Invalid Login");
        }

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        if (!user.getRoles().isEmpty()) {
        	
        	for (KatanaRole role : user.getRoles())
        	{
        		auths.add(new SimpleGrantedAuthority(role.getRole()));
        	}
        	
        } else {
        	auths = AuthorityUtils.NO_AUTHORITIES;
        }

        return new User(username, password, user.getEnabled(), // enabled
                true, // account not expired
                true, // credentials not expired
                true, // account not locked
                auths);
	}
}
	
