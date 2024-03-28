package com.insuranceapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {
	

//	from db to frontend
//	convert   AppUser to UserDetails
	public UserDetails convertToUserDetails(AppUser appUser) {
		String username = appUser.getUsername();
		String password = appUser.getPassword();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		// create roles for user
		List<String> roles = Arrays.asList("user","admin");
		for(String role:roles) {
			// create a simplegranted authority
			SimpleGrantedAuthority simpleAuthority = new SimpleGrantedAuthority(role);
			// add this to the List of grantedauthority
			authorities.add(simpleAuthority);
		}
		// create a UserDetails object
		UserDetails details = new User(username, password, authorities);
		return details;
		
				
				
	}
	
	
	
}
