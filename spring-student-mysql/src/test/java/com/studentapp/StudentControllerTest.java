package com.studentapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.studentapp.model.ApiErrors;
import com.studentapp.model.Student;


public class StudentControllerTest extends SpringStudentApplicationTests{
	
	@Test
	@Ignore
	public void testAllStudents() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
							.get("/student-api/students")
							.accept(MediaType.APPLICATION_JSON_VALUE))
							.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		
		String content = response.getContentAsString();
		List<Student> studentList = convertToObject(content,List.class);
		assertTrue(studentList.size()>0);
	}
	@Test
	public void testStudentById() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
							.get("/student-api/student-by-id/100")
							.accept(MediaType.APPLICATION_JSON_VALUE))
							.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(202, status);
		
		String content = response.getContentAsString();
		Student student= convertToObject(content,Student.class);
		assertEquals("Ramana",student.getName());
	}
	@Test
	public void testStudentByInvalidId() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
							.get("/student-api/student-by-id/1001")
							.accept(MediaType.APPLICATION_JSON_VALUE))
							.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(400, status);
		
		String content = response.getContentAsString();
		ApiErrors errors = convertToObject(content,ApiErrors.class);
		assertEquals("Invalid id",errors.getMessage());
	}
}
