package br.com.ticketSpring.loja.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.ticketSpring.loja.models.Movie;

public class MovieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Movie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		Movie movie = (Movie) target;
		if(movie.getLength() < 1){
			errors.rejectValue("length", "field.required");
		}
	}

}
