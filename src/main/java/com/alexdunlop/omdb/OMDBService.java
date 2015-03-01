package com.alexdunlop.omdb;

import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		return new Movie();
	}
}
