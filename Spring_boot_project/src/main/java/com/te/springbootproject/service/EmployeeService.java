package com.te.springbootproject.service;

import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.EmployeeLogInDto;

public interface EmployeeService {

	//EmployeeDto addEmployee(EmployeeDto employeeDto);

	EmployeeDto logIn(EmployeeLogInDto employeeLogInDto);

	EmployeeDto addEmployee(EmployeeDto employeeDto, String attachment);

}
