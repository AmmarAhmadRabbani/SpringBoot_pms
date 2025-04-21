package com.te.springbootproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.te.springbootproject.dao.EmployeeDao;
import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.EmployeeLogInDto;
import com.te.springbootproject.entity.Employee;
import com.te.springbootproject.service.EmployeeServiceImp;

@SpringBootTest
class SpringBootProjectApplicationTests {
//
//	private MockMvc mockMvc;
//
//	@Autowired
//	private EmployeeServiceImp employeeServiceImp;
//
//	@MockBean
//	private EmployeeDao employeeDao;
//
//	@Test
//	void addEmployeeTest() {
//
//		EmployeeDto employeeDto = new EmployeeDto("TYC001", "ammar", "ahmad", "ammarthegenious@gmail.com", "123");
//		Employee employee = new Employee("TYC001", "ammar", "ahmad", "ammarthegenious@gmail.com", "123", null);
//
//		when(employeeDao.save(employee)).thenReturn(employee);
//		assertEquals(employeeDto, employeeServiceImp.addEmployee(employeeDto));
//
//	}
//
//	@Test
//	void logInEmployeeTest() {
//		EmployeeLogInDto employeeLogInDto = new EmployeeLogInDto("TYC001", "123");
//		EmployeeDto employeeDto = new EmployeeDto("TYC001", "ammar", "ahmad", "ammarthegenious@gmail.com", "123");
//		Employee employee = new Employee("TYC001", "ammar", "ahmad", "ammarthegenious@gmail.com", "123", null);
//		when(employeeDao.findByEmpId(employeeDto.getEmpId())).thenReturn(employee);
//		assertEquals(employeeDto, employeeServiceImp.logIn(employeeLogInDto));
//
//	}
//
}
