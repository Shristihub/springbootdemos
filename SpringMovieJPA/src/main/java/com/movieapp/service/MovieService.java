package com.movieapp.service;

import java.util.List;

import com.movieapp.bean.Movie;

public interface MovieService {
	void addMovie(Movie movie);
	List<Movie> getAllMovies();
	List<Movie> getAllMovies(String language);
	Movie getOne(int id);
	void updateMovie(Movie movie);
	void deleteMovie(int id);
}
