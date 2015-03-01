package com.alexdunlop.omdb;

import javax.validation.constraints.Pattern;

public class MovieId {
@Pattern(regexp = "tt[0-9]+")
private String movieId;

public String getMovieId() {
	return movieId;
}

public MovieId() {
}

public void setMovieId(String movieId) {
	this.movieId = movieId;
}

}
