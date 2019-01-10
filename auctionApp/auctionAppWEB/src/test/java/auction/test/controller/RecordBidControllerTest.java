package auction.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
@ContextConfiguration("classpath:test-config.xml")
public class RecordBidControllerTest {
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void initTest() throws Exception {
		this.mockMvc.perform(get("/"))
		.andExpect(forwardedUrl("/WEB-INF/views/init.jsp"));
	}
	
	@Test
	public void registerTest() throws Exception {
		this.mockMvc.perform(get("/register"))
		.andExpect(forwardedUrl("/WEB-INF/views/auction.registeruser.jsp"));
	}

	@Test
	public void uriTest() throws Exception {
		this.mockMvc.perform(post("/recordbid"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/bidsuccess.jsp"));
	}
	
	@Test
	public void bidAmountTest() throws Exception {
		this.mockMvc.perform(post("/org.auction.controller.test"))
			.andExpect(status().is4xxClientError());
	}
	

}