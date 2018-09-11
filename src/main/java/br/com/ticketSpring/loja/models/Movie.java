package br.com.ticketSpring.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Movie {
	
	@Id
	private String id;
	@NotNull
	@NotBlank
	private String title;
	@Lob
	@NotNull
	@NotBlank
	private String description;
	@NotNull
	@Min(value=45)
	private int length;
	@DateTimeFormat(iso= ISO.DATE, pattern="dd/MM/yyyy")
	private Calendar releaseDate;
	@DateTimeFormat(iso= ISO.DATE, pattern="dd/MM/yyyy")
	private Calendar lastExhibitionDate;
	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<Price> getPrices() {
		return prices;
	}


	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
	public Calendar getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Calendar getLastExhibitionDate() {
		return lastExhibitionDate;
	}


	public void setLastExhibitionDate(Calendar lastExhibitionDate) {
		this.lastExhibitionDate = lastExhibitionDate;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", length=" + length
				+ ", prices=" + prices + "]";
	}
}
