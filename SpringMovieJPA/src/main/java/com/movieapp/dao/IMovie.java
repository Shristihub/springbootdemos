package com.movieapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.bean.Movie;
@Repository
public interface IMovie extends JpaRepository<Movie, Integer>{
	List<Movie> findByLanguage(String language);
	@Query("SELECT m FROM Movie m WHERE m.language= ?1 and m.year= ?2 ")
	List<Movie> search(String language,int year);
}
