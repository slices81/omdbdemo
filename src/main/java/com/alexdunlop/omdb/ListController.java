package com.alexdunlop.omdb;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ListController {
	@RequestMapping(value = "/search", method=RequestMethod.GET)
    @ResponseBody
	public MovieList feedback(@Valid  @ModelAttribute() MovieSearch query) {
       // logger.info("Feedback webmetod called");
		return new MovieList();
    }
}
