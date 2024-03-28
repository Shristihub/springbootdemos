package com.insuranceapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insuranceapp.model.AppUser;
import com.insuranceapp.model.AppUserMapper;
import com.insuranceapp.repository.IAppUserRepository;

@Service
@Transactional
public class AppUserServiceImpl implements UserDetailsManager {

	@Autowired
	private IAppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByUsername(username);
		if (appUser == null)
			throw new UsernameNotFoundException("username does not exist");
		UserDetails details = convertToUserDetails(appUser);
		return details;
	}

	@Override
	public void createUser(UserDetails user) {
		AppUser appUser = convertToAppUser(user);
		appUserRepository.addUser(appUser);

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

//	convert UserDetails to AppUser
	public AppUser convertToAppUser(UserDetails userDetails) {
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(password);
		System.out.println(appUser);
		return appUser;
	}

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
