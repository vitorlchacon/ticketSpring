package br.com.ticketSpring.loja.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ticketSpring.loja.daos.MovieDAO;
import br.com.ticketSpring.loja.models.Movie;

@Component
@Transactional
public class MovieService {
	
	@Autowired
	MovieDAO movieDAO = new MovieDAO();
	
	public void save(Movie movie){
		movie.setId(UUID.randomUUID().toString());
		movieDAO.save(movie);
	}
}
