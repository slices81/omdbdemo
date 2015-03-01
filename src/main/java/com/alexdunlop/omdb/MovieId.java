package com.alexdunlop.omdb;

import javax.validation.constraints.Pattern;

public class MovieId {
@Override
	public String toString() {
		return "MovieId [movieId=" + movieId + "]";
	}

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieId other = (MovieId) obj;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		return true;
	}

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
