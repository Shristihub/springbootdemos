package com.movieapp.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieapp.bean.Movie;
import com.movieapp.dao.IMovie;
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	IMovie iMovie;

	@Override
	public void addMovie(Movie movie) {
		iMovie.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return iMovie.findAll();
	}

	@Override
	public List<Movie> getAllMovies(String language) {
		System.out.println(".......");
		System.out.println(iMovie.search("English", 2000));
		return iMovie.findByLanguage(language);
	}

	@Override
	public Movie getOne(int id) {
		
		return iMovie.findOne(id);
	}

	@Override
	public void updateMovie(Movie movie) {
		iMovie.save(movie);
	}

	@Override
	public void deleteMovie(int id) {
		iMovie.delete(id);
	}

	

}
