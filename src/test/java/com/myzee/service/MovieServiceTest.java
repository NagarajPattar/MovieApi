package com.myzee.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myzee.model.Movie;
import com.myzee.repository.MovieRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {
	
	@Autowired
	MovieService movieService;
	@Autowired
	MovieRepository movieRep;
	
	@Test
	public void testSaveMovie() {
		int count = (int) movieRep.count();
		Movie m = new Movie(++count, "Padman", 2017, 5);
		movieService.saveMovie(m);
		
		assertEquals(count, movieRep.findByName(m.getName()).getId());
	}
	
	@Test
	public void testUpdateMovie() {
		Movie m = movieRep.findByName("Raid");
		m.setRating(3.0);
		m.setYear(2019);
		movieService.updateMovie(m);
		
		assertEquals(2019, movieRep.findByName("Raid").getYear());
	}
	
	@Test
	public void testFetchAllMovies() {
		int expected = (int) movieRep.count();
		List<Movie> movieList = movieService.fetchAllMovies();
		int actual = movieList.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFetchBasedOnYear() {
		List<Movie> movList = movieService.fetchBasedOnYear(2016);
		int expected = 0;
		int actual = movList.stream().filter((m) -> m.getYear()!=2016).collect(Collectors.toList()).size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFetchBasedOnRatings() {
		List<Movie> movList = movieService.fetchBasedOnRatings(4);
		int expected = 0;
		int actual = movList.stream().filter((m) -> m.getRating()!=4).collect(Collectors.toList()).size();
		assertEquals(expected, actual);
	}

}
