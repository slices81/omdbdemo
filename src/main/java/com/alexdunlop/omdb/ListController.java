package com.alexdunlop.omdb;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ListController {
	@RequestMapping(value = "/search", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<Void> search() {
       // logger.info("Feedback webmetod called");
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }
}
