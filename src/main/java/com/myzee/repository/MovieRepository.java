package com.myzee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myzee.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
	public List<Movie> findAllByYear(int year);
	
	public List<Movie> findAllByRating(double rating);
	public Movie findByName(String name);
}
