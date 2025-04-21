package com.te.springbootproject;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.awt.PageAttributes.MediaType;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.springbootproject.controller.EmployeeController;
import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.EmployeeLogInDto;
import com.te.springbootproject.dto.MaintainTimeDto;
import com.te.springbootproject.dto.ReimbustmentDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.service.EmployeeServiceImp;
import com.te.springbootproject.service.MaintainTimeServiceImp;
import com.te.springbootproject.service.ReimbustmentServiceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
//class EmployeeControllerTest {
//
//	private MockMvc mockMvc;
//
//	@MockBean
//	private EmployeeServiceImp employeeServiceImp;
//
//	@MockBean
//	private MaintainTimeServiceImp maintainTimeServiceImp;
//
//	@MockBean
//	private ReimbustmentServiceImp reimbustmentServiceImp;
//
//	@Autowired
//	private EmployeeController employeeController;
//
//	@BeforeEach
//	public void SetUp() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
//	}
//
//	@Test
//	void logInControllerTest()
//			throws JsonProcessingException, JsonMappingException, UnsupportedEncodingException, Exception {
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		EmployeeDto employeeDto = new EmployeeDto("TYC001", "ammar", "ahmad", "ammarthegenious@gmail.com", "123");
//		EmployeeLogInDto employeeLogInDto = new EmployeeLogInDto("TYC001", "123");
//		when(employeeServiceImp.logIn(employeeLogInDto)).thenReturn(employeeDto);
//		String contentAsString = mockMvc
//				.perform(post("/logIn").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
//						.content(objectMapper.writeValueAsString(employeeLogInDto)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		ResponseDto responseDto = objectMapper.readValue(contentAsString, ResponseDto.class);
//		assertEquals("login successfull", responseDto.getMessage());
//
//	}
////	@Test
////	void getTimeSheetControllerTest() throws Exception{
////		ObjectMapper objectMapper = new ObjectMapper();
////		//MaintainTimeDto maintainTimeDto=new MaintainTimeDto(1, "TYC001", "21/11/2022", "hrms", "9:30Am", "7:00Pm",
////		//		"pending");
////		
////		
////	
////		when(maintainTimeServiceImp.getTimeSheet("TYC001")).thenReturn(maintainTimeDto);
////	}
//
//	@Test
//	void timeSheetControllerTest() throws Exception {
//		ObjectMapper objectMapper = new ObjectMapper();
//		MaintainTimeDto maintainTimeDto = new MaintainTimeDto(1, "TYC001", "21/11/2022", "hrms", "9:30Am", "7:00Pm",
//				"pending");
//		when(maintainTimeServiceImp.timeSheet(maintainTimeDto)).thenReturn(maintainTimeDto);
//
//		String contentAsString = mockMvc
//				.perform(post("/timesheet").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
//						.content(objectMapper.writeValueAsString(maintainTimeDto)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		ResponseDto responseDto = objectMapper.readValue(contentAsString, ResponseDto.class);
//		assertEquals("timesheet maintained", responseDto.getMessage());
//
//	}
//
//	@Test
//	void reimbustmentControllerTest() throws Exception {
//		ObjectMapper objectMapper = new ObjectMapper();
//		ReimbustmentDto reimbustmentDto = new ReimbustmentDto(1, "TYC001", "21/11/2022", "delhi", "total", "40000",
//				"pending");
//		when(reimbustmentServiceImp.reimbustment(reimbustmentDto)).thenReturn(reimbustmentDto);
//
//		String contentAsString = mockMvc
//				.perform(
//						post("/reimbustment").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
//								.content(objectMapper.writeValueAsString(reimbustmentDto)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//		ResponseDto responseDto = objectMapper.readValue(contentAsString, ResponseDto.class);
//		assertEquals("successfully claimed", responseDto.getMessage());
//	}
//
//}
