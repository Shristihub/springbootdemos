package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.AppUser;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer>{

	AppUser findByUsername(String username);
}
