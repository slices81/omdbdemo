package com.alexdunlop.omdb;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;








import org.hamcrest.Matchers;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import com.alexdunlop.omdb.config.WebMvcConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebMvcConfig.class)
public class MovieResourceTest {
	private MediaType contentType = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());

	private  MockMvc mockMvc;

	@Autowired
	private  WebApplicationContext webApplicationContext;

	@Before
	public  void setUpBefore() throws Exception {
		  mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testSearchNoQuery() {
		try {
			mockMvc.perform(get( "/search"
			        ))
			        .andExpect(status().isUnprocessableEntity())
			        .andExpect(content().contentType(contentType))
			        .andExpect(jsonPath("$.message", Matchers.is("Validation Failed")));
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
	public void testSearchQuery() {
		try {
			mockMvc.perform(get( "/search?Name=X-Men"
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
	public void testSearchEmptyQuery() {
		try {
			mockMvc.perform(get( "/search?Name="
			        ))
			        .andExpect(status().isUnprocessableEntity())
			        .andExpect(content().contentType(contentType))
			        .andExpect(jsonPath("$.message", Matchers.is("Validation Failed")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	

		@Test
		public void testSearchQuerBadChars() {
			try {
				mockMvc.perform(get( "/search?Name= "
				        ))
				        .andExpect(status().isUnprocessableEntity())
				        .andExpect(content().contentType(contentType))
				        .andExpect(jsonPath("$.message", Matchers.is("Validation Failed")));
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
		public void testSearchShortQuery() {
			try {
				mockMvc.perform(get( "/search?Name=X"
				        ))
				        .andExpect(status().isUnprocessableEntity())
				        .andExpect(content().contentType(contentType))
				        .andExpect(jsonPath("$.message", Matchers.is("Validation Failed")));
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
		public void testAtLeastOneResult() {
			try {
				mockMvc.perform(get( "/search?Name=X-Men"
				        ))
				        .andExpect(status().isOk())
				        .andExpect(content().contentType(contentType))
				         .andExpect(jsonPath("$.movies", Matchers.not(Matchers.emptyCollectionOf(Movie.class))));
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
		public void testNoResults() {
			try {
				mockMvc.perform(get( "/search?Name=YYYYYYYYYYYZZZZZz"
				        ))
				        .andExpect(status().isOk())
				        .andExpect(content().contentType(contentType))
				        
				         .andExpect(jsonPath("$", Matchers.emptyCollectionOf(Movie.class)));
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
		public void testMovieById() {
			try {
				mockMvc.perform(get( "/movie/tt1270798"
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
		public void testMovieBIdNoFormat() {
			try {
				mockMvc.perform(get( "/movie/tttx"
				        ))
				        .andExpect(status().isUnprocessableEntity())
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
