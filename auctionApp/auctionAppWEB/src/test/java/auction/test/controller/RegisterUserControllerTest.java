/**
 * 
 */
package auction.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Kirankumar
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:controller-test-config.xml")
public class RegisterUserControllerTest {
	
	private String VIEW_PATH="/WEB-INF/views";
	
	@Autowired
	WebApplicationContext webAppContext;
	
	MockMvc mockMVC;
	
	@Before
	public void setup() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void registerURITest() throws Exception {
		mockMVC.perform(get("/registervehicleg"))
		.andExpect(forwardedUrl(VIEW_PATH+"/registervehicleg.jsp"));
	}
	
/*	Need to add tests for 
 *  1.Contoller request building 
 *  2.Request Validation, 
 *  3.Service call, 
 *  4.Response model creation
	@Test
	public void registeruserURITest() throws Exception{
		mockMVC.perform(post("/registervehicle"))
		.andExpect(forwardedUrl(VIEW_PATH+"/registervehicles.jsp"));
	}*/
	
}
