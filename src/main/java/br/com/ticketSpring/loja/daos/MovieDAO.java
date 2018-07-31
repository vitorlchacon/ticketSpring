package br.com.ticketSpring.loja.daos;

import java.util.List;

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

	public List<Movie> listAll() {
		List<Movie> movies = manager.createQuery("SELECT DISTINCT m FROM Movie m JOIN FETCH m.prices", Movie.class).getResultList();
		return movies;
	}

}
