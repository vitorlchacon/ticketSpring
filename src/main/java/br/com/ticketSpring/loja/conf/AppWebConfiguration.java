package br.com.ticketSpring.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.ticketSpring.loja.controllers.HomeController;
import br.com.ticketSpring.loja.daos.MovieDAO;
import br.com.ticketSpring.loja.service.MovieService;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, MovieDAO.class, MovieService.class})
public class AppWebConfiguration {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
