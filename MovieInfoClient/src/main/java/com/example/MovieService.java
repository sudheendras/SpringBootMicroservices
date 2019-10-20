package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("movieService")
public class MovieService {

	@Autowired
	RestTemplate restTemplate;
	
	public List<Movie> movieList = new ArrayList<Movie>();
	
	public Movie getMovies() {
		Movie movie = restTemplate.getForObject("http://MOVIEINFO/MovieInfo/getMovies", Movie.class);
		return movie;
	}
}
