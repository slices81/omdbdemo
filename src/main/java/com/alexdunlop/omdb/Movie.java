package com.alexdunlop.omdb;

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

public String getName() 
{
	return name;
}

public void setName(String name) 
{
	this.name = name;
}

@Override
public boolean equals(Object obj) {
	  if (obj == null) { return false; }
	   if (obj == this) { return true; }
	   if (obj.getClass() != getClass()) {
	     return false;
	   }
	   Movie movie = (Movie) obj;
	   return new EqualsBuilder()
	                 .appendSuper(super.equals(obj))
	                 .append(name, movie.name)
	                 .isEquals();
}

@Override
public int hashCode() {
	 HashCodeBuilder builder = new HashCodeBuilder();
	    builder.append(name);
	    return builder.toHashCode();
}

@Override
public String toString() {
	 return new ToStringBuilder(this).
		       append("name", name).
		       toString();
}

}
