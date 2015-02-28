package com.alexdunlop.omdb;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;






import org.junit.Before;
//import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.alexdunlop.omdb.config.WebMvcConfig;

//import com.alexdunlop81.rantandrave.questionnaireapi.Application;

//import com.alexdunlop.omdb.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@SpringApplicationConfiguration()//(classes = Application.class)
@ContextConfiguration(classes = WebMvcConfig.class)//(classes = {TestContext.class, WebAppContext.class})
public class ListControllerTest {
	private MediaType contentType = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private  MockMvc mockMvc;

	@Autowired
	private  WebApplicationContext webApplicationContext;

	@Before
	public  void setUpBefore() throws Exception {
		  mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testSuccess() {
		try {
			mockMvc.perform(get( "/api/v1/search?query=X-Men"
			        ))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
             /* .andExpect(jsonPath("$.name", Matchers.is("fred")))
               .andExpect(jsonPath("$.score", Matchers.is(1)))
               .andExpect(jsonPath("$.comment", Matchers.is("ok")));*/
	}
	
	@Test
	public void testSuccessOnly() {
		try {
			mockMvc.perform(get( "/api/v1/search?query=X-Men"
			        ))
			        .andExpect(status().isOk())
			      ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
             /* .andExpect(jsonPath("$.name", Matchers.is("fred")))
               .andExpect(jsonPath("$.score", Matchers.is(1)))
               .andExpect(jsonPath("$.comment", Matchers.is("ok")));*/
	}
	@Test
	public void testContentType() {
		try {
			mockMvc.perform(get( "/search?query=X-Men"
			        ))
			        
			        .andExpect(content().contentType(contentType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
             /* .andExpect(jsonPath("$.name", Matchers.is("fred")))
               .andExpect(jsonPath("$.score", Matchers.is(1)))
               .andExpect(jsonPath("$.comment", Matchers.is("ok")));*/
	}

}
