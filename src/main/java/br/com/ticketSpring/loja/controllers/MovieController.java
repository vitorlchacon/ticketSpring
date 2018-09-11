package br.com.ticketSpring.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ticketSpring.loja.models.Movie;
import br.com.ticketSpring.loja.models.TicketType;
import br.com.ticketSpring.loja.service.MovieService;
import br.com.ticketSpring.loja.validations.MovieValidator;

@Controller
@RequestMapping(value="/movie") 
public class MovieController {
	
	@Autowired
	private MovieService movieService = new MovieService();
	
	@RequestMapping(method=RequestMethod.POST, name="saveMovie")
	public ModelAndView save(@Valid Movie movie, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return form(movie);
		}
		movieService.save(movie);
		redirectAttributes.addFlashAttribute("sucesso", movie.getTitle() + " está em cartaz!");
		return new ModelAndView("redirect:movie");
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public ModelAndView form(Movie movie){
		ModelAndView modelAndView = new ModelAndView("movie/form");
		modelAndView.addObject("types", TicketType.values());
		modelAndView.addObject("movie", movie);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("movie/list");
		List<Movie> movies = movieService.listAll();
		modelAndView.addObject("movies", movies);
		return modelAndView;
	}

}
