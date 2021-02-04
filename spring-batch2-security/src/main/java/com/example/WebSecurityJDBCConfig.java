package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class WebSecurityJDBCConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	// jdbc authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.withDefaultSchema()
		.withUser(
				User.withUsername("ram")
				.password(passwordEncoder().encode("ram123"))
				.roles("USER"))
				.withUser(User.withUsername("admin")
				.password(passwordEncoder().encode("admin123"))
				.roles("ADMIN"));
			}
		
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
//		.antMatchers("h2-console/**").hasRole("ADMIN")
		.antMatchers("/api/**").hasAnyRole("USER","ADMIN")
		.antMatchers("h2-console/**","/**","/admin/**").hasRole("ADMIN")
		.and()
		.formLogin();
		http.csrf().disable();
		 http.headers().frameOptions().disable();
		
	}

	
}
