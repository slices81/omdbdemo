package com.alexdunlop.omdb;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.validation.ObjectError;

public class SearchResponse {
private List<Movie> movies;
private String result;
public SearchResponse(String result, ArrayList<Movie> movies) {
	this.result = result;
	this.movies = movies;
}

public SearchResponse(){
	
}
@Override
public boolean equals(Object obj) {
	  if (obj == null) { return false; }
	   if (obj == this) { return true; }
	   if (obj.getClass() != getClass()) {
	     return false;
	   }
	   SearchResponse response = (SearchResponse) obj;
	   return new EqualsBuilder()
	                 .appendSuper(super.equals(obj))
	                 .append(result, response.result)
	                 .append(movies, response.movies)
	                 .isEquals();
}

@Override
public int hashCode() {
	 HashCodeBuilder builder = new HashCodeBuilder();
	    builder.append(result);
	    builder.append(movies);
	    return builder.toHashCode();
}

@Override
public String toString() {
	 return new ToStringBuilder(this).
		       append("result", result).
		       append("movies", movies).
		       toString();
}

public SearchResponse(String result) {
	this.result = result;
}



public List<Movie> getMovies() {
	return movies;
}
public void setMovies(List<Movie> movies) {
	this.movies = movies;
}

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}


}
