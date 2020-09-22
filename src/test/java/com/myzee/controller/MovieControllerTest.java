package com.myzee.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myzee.model.Movie;
import com.myzee.service.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MovieService movService;
	
	@Test
	public void testSaveMovie() throws Exception {
				
		Movie o = new Movie(8, "KGF", 2019, 5);
		ObjectMapper objectMapping = new ObjectMapper();
		objectMapping.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String json = objectMapping.writeValueAsString(o);
		
		mockMvc.perform(post("/movie/add")
				.contentType(MediaType.APPLICATION_JSON)
//				.content("{id:8, name:KGF, year:2019, rating:5}")
				.content(json)
				.characterEncoding("utf-8")
				)
		.andExpect(status().is(200));
	}

}
