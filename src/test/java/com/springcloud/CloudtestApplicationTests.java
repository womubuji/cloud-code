package com.springcloud;

import com.springcloud.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudtestApplicationTests {

	private MockMvc mockMvc;

	@Value("${com.string.value}")
	private String stringValue;
	@Value("${com.int.value}")
	private String intValue;
	@Value("${com.long.value}")
	private String longValue;

	@Before
	public void setUp() {
		System.out.println("******"+stringValue);
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void hello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).
				andExpect(content().string(Matchers.equalTo("eat apple")));
	}

	@Test
	public void contextLoads() {
	}

}
