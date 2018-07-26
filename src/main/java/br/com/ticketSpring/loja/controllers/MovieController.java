package br.com.ticketSpring.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ticketSpring.loja.models.Movie;
import br.com.ticketSpring.loja.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService = new MovieService();
	
	@RequestMapping("/movie/form")
	public String form(){
		return "movie/form";
	}
	
	@RequestMapping("/movie")
	public String save(Movie movie){
		System.out.println("Cadastrando o produto: " + movie);
		movieService.save(movie);
		return "movie/ok";
	}
}
