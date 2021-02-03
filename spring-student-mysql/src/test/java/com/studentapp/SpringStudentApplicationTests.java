package com.studentapp;

import java.io.IOException;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes=SpringStudentMysqlApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
abstract class SpringStudentApplicationTests {

	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	public   String convertToJson(Object obj) throws JsonProcessingException{
		ObjectMapper mapper  = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	public <T> T convertToObject(String json,Class<T> clazz) throws JsonParseException,IOException,JsonMappingException{
		ObjectMapper mapper  = new ObjectMapper();
		return mapper.readValue(json,clazz);
	}
	
}
