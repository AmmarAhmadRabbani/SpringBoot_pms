package com.te.springbootproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.springbootproject.controller.AdminController;
import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.dto.RoleDto;
import com.te.springbootproject.service.EmployeeServiceImp;
import com.te.springbootproject.service.RoleServiceImp;

//@SpringBootTest
//class AdminControllerTest {
//
//	private MockMvc mockMvc;
//
//	@MockBean
//	private EmployeeServiceImp employeeServiceImp;
//
//	@MockBean
//	private RoleServiceImp roleServiceImp;
//
//	@Autowired
//	private AdminController adminController;
//
//	@BeforeEach
//	public void SetUP() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
//	}
//
//	@Test
//	void addEmployeeControllerTest() throws Exception {
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		EmployeeDto employeeDto = new EmployeeDto("TYC001", "ammar", "ahmad", "ammarthegenious@gmail.com", "123");
//		when(employeeServiceImp.addEmployee(employeeDto)).thenReturn(employeeDto);
//		String contentAsString = mockMvc
//				.perform(post("/add").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
//						.content(objectMapper.writeValueAsString(employeeDto)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		ResponseDto responseDto = objectMapper.readValue(contentAsString, ResponseDto.class);
//		assertEquals("employee added successfully", responseDto.getMessage());
//
//	}
//
//	@Test
//	void addRoleControllerTest() throws Exception {
//		ObjectMapper objectMapper = new ObjectMapper();
//		RoleDto roleDto = new RoleDto("TYC101", "tanveer");
//		when(roleServiceImp.addRole(roleDto)).thenReturn(roleDto);
//		String contentAsString = mockMvc
//				.perform(post("/addRole").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
//						.content(objectMapper.writeValueAsString(roleDto)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		ResponseDto responseDto = objectMapper.readValue(contentAsString, ResponseDto.class);
//		assertEquals("successfully added", responseDto.getMessage());
//	}
//
//}
