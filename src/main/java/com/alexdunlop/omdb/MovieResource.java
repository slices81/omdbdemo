package com.alexdunlop.omdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MovieResource {
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SearchResponse search(@Valid @ModelAttribute() Movie query,
			BindingResult result) {
		if (!result.hasFieldErrors()) {
			return new SearchResponse("OK", new ArrayList<Movie>());
		} else {
			
			return new SearchResponse("Failed", result.getAllErrors());
		}
	}
}
