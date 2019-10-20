package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	
	public List<Movie> movieList = new ArrayList<Movie>();
	
	@GetMapping("/getMovies")
	public Movie getMovies() {
		Movie movie1 = new Movie(1,"Avenger");
		/*Movie movie2 = new Movie(2,"King");
		Movie movie3 = new Movie(3,"Batman");
		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);*/
		return movie1;
	}
}
