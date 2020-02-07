package com.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.bean.Movie;
import com.movieapp.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	@RequestMapping("/movies")
	public List<Movie> getAll(){
		return movieService.getAllMovies();
	}
	
	@RequestMapping("/movies/{language}")
	public List<Movie> getMoviesByLanguage(
			@PathVariable("language")String language){
		return movieService.getAllMovies(language);
	}
	@RequestMapping("/movies/one/{movieid}")
	public Movie getOne(
			@PathVariable("movieid")int id){
		return movieService.getOne(id);
	}
}
