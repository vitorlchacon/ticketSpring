package br.com.ticketSpring.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ticketSpring.loja.models.Movie;

@Repository
public class MovieDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Movie movie) {
		manager.persist(movie);
	}

}
