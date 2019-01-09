/**
 * 
 */
package auction.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
@ContextConfiguration("test-config.xml")
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
		mockMVC.perform(get("/register"))
		.andExpect(forwardedUrl(VIEW_PATH+"/registeruser.jsp"));
	}
	
	@Test
	public void registeruserURITest() throws Exception{
		mockMVC.perform(post("/registeruser"))
		.andExpect(forwardedUrl(VIEW_PATH+"/registersuccess.jsp"));
	}

}
