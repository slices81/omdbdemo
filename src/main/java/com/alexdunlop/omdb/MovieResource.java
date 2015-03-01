package com.alexdunlop.omdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexdunlop.omdb.exceptions.InvalidRequestException;
import com.omdbapi.Omdb;
import com.omdbapi.OmdbConnectionErrorException;
import com.omdbapi.OmdbMovieNotFoundException;
import com.omdbapi.OmdbSyntaxErrorException;
import com.omdbapi.SearchResult;

import javax.validation.Valid;

@RestController
public class MovieResource {
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Movie> search(@Valid @ModelAttribute() Movie query,
			BindingResult result) {
		
		if (!result.hasFieldErrors()) {
			String title = query.getName();
			ArrayList<Movie> movies;
				movies = OMDBService.findMovies(title);
				return movies;
	
			
		} else {
			
			throw new InvalidRequestException("Validation Failed", result);
		}
	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Movie findMovie(@Valid @ModelAttribute()  MovieId movieId, BindingResult result) {
		if (!result.hasErrors()){
			Movie movie = OMDBService.findMovie(movieId.getMovieId());
			return movie;
			}
		else{
			throw new InvalidRequestException("Validation Failed", result);
		}
		
	}
}
