package com.alexdunlop.omdb;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Movie 
{

@NotNull
@NotEmpty
@Pattern(regexp = ".*\\S.*")
@Length(min = 3)
private String name;
private String imdbID;
private List<String> actors;
private String awards;
private String country;
private String director;
private List<String> genres;
private float imdbRating;
private long imdbVotes;
private String language;
private String metaScore;
private String plot;
private String poster;
private String rated;
private String runtime;
private String type;
private List<String> writers;

public Movie(String imdbID, String fullTitle) {
	this.name = fullTitle;
	this.setImdbID(imdbID);
}

public Movie(){
	
}
public String getName() 
{
	return name;
}

public void setName(String name) 
{
	this.name = name;
}


@Override
public String toString() {
	return "Movie [name=" + name + ", imdbID=" + imdbID + ", actors=" + actors
			+ ", awards=" + awards + ", country=" + country + ", director="
			+ director + ", genres=" + genres + ", imdbRating=" + imdbRating
			+ ", imdbVotes=" + imdbVotes + ", language=" + language
			+ ", metaScore=" + metaScore + ", plot=" + plot + ", poster="
			+ poster + ", rated=" + rated + ", runtime=" + runtime + ", type="
			+ type + ", writers=" + writers + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((actors == null) ? 0 : actors.hashCode());
	result = prime * result + ((awards == null) ? 0 : awards.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((director == null) ? 0 : director.hashCode());
	result = prime * result + ((genres == null) ? 0 : genres.hashCode());
	result = prime * result + ((imdbID == null) ? 0 : imdbID.hashCode());
	result = prime * result + Float.floatToIntBits(imdbRating);
	result = prime * result + (int) (imdbVotes ^ (imdbVotes >>> 32));
	result = prime * result + ((language == null) ? 0 : language.hashCode());
	result = prime * result + ((metaScore == null) ? 0 : metaScore.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((plot == null) ? 0 : plot.hashCode());
	result = prime * result + ((poster == null) ? 0 : poster.hashCode());
	result = prime * result + ((rated == null) ? 0 : rated.hashCode());
	result = prime * result + ((runtime == null) ? 0 : runtime.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((writers == null) ? 0 : writers.hashCode());
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
	Movie other = (Movie) obj;
	if (actors == null) {
		if (other.actors != null)
			return false;
	} else if (!actors.equals(other.actors))
		return false;
	if (awards == null) {
		if (other.awards != null)
			return false;
	} else if (!awards.equals(other.awards))
		return false;
	if (country == null) {
		if (other.country != null)
			return false;
	} else if (!country.equals(other.country))
		return false;
	if (director == null) {
		if (other.director != null)
			return false;
	} else if (!director.equals(other.director))
		return false;
	if (genres == null) {
		if (other.genres != null)
			return false;
	} else if (!genres.equals(other.genres))
		return false;
	if (imdbID == null) {
		if (other.imdbID != null)
			return false;
	} else if (!imdbID.equals(other.imdbID))
		return false;
	if (Float.floatToIntBits(imdbRating) != Float
			.floatToIntBits(other.imdbRating))
		return false;
	if (imdbVotes != other.imdbVotes)
		return false;
	if (language == null) {
		if (other.language != null)
			return false;
	} else if (!language.equals(other.language))
		return false;
	if (metaScore == null) {
		if (other.metaScore != null)
			return false;
	} else if (!metaScore.equals(other.metaScore))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (plot == null) {
		if (other.plot != null)
			return false;
	} else if (!plot.equals(other.plot))
		return false;
	if (poster == null) {
		if (other.poster != null)
			return false;
	} else if (!poster.equals(other.poster))
		return false;
	if (rated == null) {
		if (other.rated != null)
			return false;
	} else if (!rated.equals(other.rated))
		return false;
	if (runtime == null) {
		if (other.runtime != null)
			return false;
	} else if (!runtime.equals(other.runtime))
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	if (writers == null) {
		if (other.writers != null)
			return false;
	} else if (!writers.equals(other.writers))
		return false;
	return true;
}

public String getImdbID() {
	return imdbID;
}

public void setImdbID(String imdbID) {
	this.imdbID = imdbID;
}

public void setActors(List<String> actors) {
	this.actors = actors;
	
}

public void setAwards(String awards) {
	this.awards = awards;
	
}

public void setCountry(String country) {
	this.country = country;
	
}

public void setDirector(String director) {
	this.director = director;
	
}

public void setGenres(List<String> genres) {
	this.genres = genres;
	
}

public void setImdbRating(float imdbRating) {
	this.imdbRating = imdbRating;
	
}

public void setImdbVotes(long imdbVotes) {
	this.imdbVotes = imdbVotes;
	
}

public void setLanguage(String language) {
	this.language = language;
	
}

public void setMetaScore(String metascore) {
	this.metaScore = metascore;
	
}

public void setPlot(String plot) {
	this.plot = plot;
	
}

public void setPoster(String poster) {
	this.poster = poster;
	
}

public void setRated(String rated) {
	this.rated = rated;
	
}

public List<String> getActors() {
	return actors;
}

public String getAwards() {
	return awards;
}

public String getCountry() {
	return country;
}

public String getDirector() {
	return director;
}

public List<String> getGenres() {
	return genres;
}

public float getImdbRating() {
	return imdbRating;
}

public long getImdbVotes() {
	return imdbVotes;
}

public String getLanguage() {
	return language;
}

public String getMetaScore() {
	return metaScore;
}

public String getPlot() {
	return plot;
}

public String getPoster() {
	return poster;
}

public String getRated() {
	return rated;
}

public String getRuntime() {
	return runtime;
}

public String getType() {
	return type;
}

public List<String> getWriters() {
	return writers;
}

public void setRuntime(String runtime) {
	this.runtime = runtime;
	
}

public void setType(String type) {
	this.type = type;
	
}

public void setWriters(List<String> writers) {
	this.writers = writers;
	
}

}
