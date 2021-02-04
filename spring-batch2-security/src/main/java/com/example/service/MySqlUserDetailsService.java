package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.AppUser;
import com.example.repo.AppUserRepository;

@Service
public class MySqlUserDetailsService implements UserDetailsService{

	@Autowired
	AppUserRepository repository;

	@Autowired
	PasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		String password1 = encoder.encode("raju123");
//		String password2 = encoder.encode("admin123");
//		AppUser one = new AppUser("raju",1,password1,"USER");
//		repository.save(one);
//		AppUser two = new AppUser("admin",2,password2,"ADMIN");
//		repository.save(two);
//		
		AppUser user = repository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("user not found");
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getAuthority()));
		User nuser = new User(user.getUsername(),user.getPassword(),authorities);
		return nuser;
	}
	
}
