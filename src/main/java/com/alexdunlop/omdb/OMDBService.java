package com.alexdunlop.omdb;

import java.util.ArrayList;
import java.util.List;

import com.alexdunlop.omdb.exceptions.MovieSearchException;
import com.omdbapi.MovieType;
import com.omdbapi.Omdb;
import com.omdbapi.OmdbConnectionErrorException;
import com.omdbapi.OmdbMovieNotFoundException;
import com.omdbapi.OmdbSyntaxErrorException;
import com.omdbapi.SearchResult;

public class OMDBService {
	public static ArrayList<Movie> findMovies(String title) throws MovieSearchException {
		try {
			ArrayList<Movie> movies = new ArrayList<Movie>();
			List<SearchResult> results = new Omdb().search(title);
			for (SearchResult searchResult : results){
				String imdbID = searchResult.getImdbID();
				String fullTitle = searchResult.getTitle();
				Movie movie = new Movie(imdbID, fullTitle);
				movies.add(movie);
				
			}
			return movies;
		} catch (OmdbMovieNotFoundException e) {
			return new ArrayList<Movie>();
		} catch (OmdbConnectionErrorException e) {
			throw new MovieSearchException("Error", e);
		} catch (OmdbSyntaxErrorException e) {
			throw new MovieSearchException("Error", e);
		}
	}

	public static Movie findMovie(String movieId) {
		try {
			com.omdbapi.Movie result = new Omdb().getById(movieId);
			Movie movie = new Movie();
			movie.setActors(result.getActors());
			movie.setAwards(result.getAwards());
			String country = result.getCountry();
			String director = result.getDirector();
			List<String> genres = result.getGenres();
			String imdbId = result.getImdbId();
			float imdbRating = result.getImdbRating();
			long imdbVotes = result.getImdbVotes();
			String language = result.getLanguage();
			String metascore = result.getMetascore();
			String plot = result.getPlot();
			String poster = result.getPoster();
			String rated = result.getRated();
			String runtime = result.getRuntime();
			String title = result.getTitle();
			String type = result.getType().name();
			List<String> writers = result.getWriters();
			movie.setCountry(country);
			movie.setDirector(director);
			movie.setGenres(genres);
			movie.setImdbID(imdbId);
			movie.setImdbRating(imdbRating);
			movie.setImdbVotes(imdbVotes);
			movie.setLanguage(language);
			movie.setMetaScore(metascore);
			movie.setPlot(plot);
			movie.setPoster(poster);
			movie.setRated(rated);
			movie.setRuntime(runtime);
			movie.setName(title);
			movie.setType(type);
			movie.setWriters(writers);
			
			
			
			return movie;
		} catch (OmdbConnectionErrorException e) {
			throw new MovieSearchException("OMDB Error");
		} catch (OmdbSyntaxErrorException e) {
			throw new MovieSearchException("OMDB Error");
		} catch (OmdbMovieNotFoundException e) {
			throw new MovieSearchException("Movie Not found");
		}
		
	}
}
