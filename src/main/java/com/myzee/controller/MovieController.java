package com.myzee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myzee.model.Movie;
import com.myzee.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@PostMapping(path = "/add", consumes = "application/json")
	public void saveMovie(@RequestBody Movie m) {
		movieService.saveMovie(m);
	}
	
	@PutMapping(path = "/update", consumes = "application/json")
	public void updateMovie(@RequestBody Movie m) {
		movieService.updateMovie(m);
	}
	
	@GetMapping("/getall")
	public List<Movie> fetchAllMovies() {
		return movieService.fetchAllMovies();
	}
	
	@GetMapping("/byyear/{year}")
	public List<Movie> fetchBasedOnYear(@PathVariable int year) {
		return movieService.fetchBasedOnYear(year);
	}
	
	@GetMapping("/byratings/{rating}")
	public List<Movie> fetchBasedOnRatings(@PathVariable double rating) {
		return movieService.fetchBasedOnRatings(rating);
	}
}
