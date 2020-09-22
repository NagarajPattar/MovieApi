package com.myzee.init.data;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myzee.model.Movie;
import com.myzee.repository.MovieRepository;

@Component
public class MovieInitializer implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepo;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		movieRepo.save(new Movie(1, "TZP", 2001, 5));
		movieRepo.save(new Movie(2, "mission mangal", 2018, 5));
		movieRepo.save(new Movie(3, "URI", 2018, 5));
		movieRepo.save(new Movie(4, "Raid", 2018, 4));
		movieRepo.save(new Movie(5, "AirLift", 2016, 4));
		movieRepo.save(new Movie(6, "Gold", 2016, 3));
		
	}

}
