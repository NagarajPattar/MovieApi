package com.myzee.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myzee.model.Movie;
import com.myzee.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	public void saveMovie(Movie m) {		
		movieRepository.save(m);
	}
	
	public void updateMovie(Movie m) {
		
		Movie updateMovie = movieRepository.findByName(m.getName());
		updateMovie.setRating(m.getRating());
		updateMovie.setYear(m.getYear());
		movieRepository.save(updateMovie);
	}
	
	public List<Movie> fetchAllMovies() {
		List<Movie> resList = new ArrayList<Movie>();
		Iterator<Movie> it = movieRepository.findAll().iterator();
		it.forEachRemaining((m) -> resList.add(m));
		resList.forEach(System.out::println);
		return resList;
	}
	
	public List<Movie> fetchBasedOnYear(int year) {
		return movieRepository.findAllByYear(year);
	}
	
	public List<Movie> fetchBasedOnRatings(double rating) {
		return movieRepository.findAllByRating(rating);
	}
}
