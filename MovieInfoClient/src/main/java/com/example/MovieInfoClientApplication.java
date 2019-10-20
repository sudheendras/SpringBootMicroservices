package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoClientApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext context;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate(); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieInfoClientApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		MovieService movieService = (MovieService)context.getBean("movieService");
		Movie movie = movieService.getMovies();
		System.out.println(movie.getMovieId()+"\t"+movie.getMovieName());
	}
}
