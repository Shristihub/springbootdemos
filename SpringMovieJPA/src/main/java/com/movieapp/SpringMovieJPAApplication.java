package com.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieapp.bean.Movie;
import com.movieapp.service.MovieService;

@SpringBootApplication
public class SpringMovieJPAApplication 
implements CommandLineRunner {

	@Autowired
	MovieService movieService;
	
	public static void main(String[] args) {
		SpringApplication app = 
	new SpringApplication(SpringMovieJPAApplication.class);
		app.run();
	}

	@Override
	public void run(String... arg0) throws Exception {
		Movie movie  = new Movie();
		movie.setName("ABC ");
		movie.setLanguage("Tamil");
		movie.setGenre("Action");
		movie.setYear(2014);;
		System.out.println(movie);
		movieService.addMovie(movie);
		
		
		movieService
		.getAllMovies().stream()
		.forEach((smovie)->System.out.println(smovie));
		
		System.out.println();
		movieService
		.getAllMovies("english")
		.stream()
		.forEach((smovie)->{System.out.println(smovie);});
		
		System.out.println();
		System.out.println(movieService.getOne(1));
	}
}
