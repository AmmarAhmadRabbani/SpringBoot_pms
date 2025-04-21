package com.te.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.EmployeeLogInDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.dto.RoleDto;
//import com.te.springbootproject.entity.EmailDetails;
import com.te.springbootproject.entity.Employee;
import com.te.springbootproject.entity.MaintainTime;
import com.te.springbootproject.entity.Role;
//import com.te.springbootproject.service.EmailService;
import com.te.springbootproject.service.EmployeeService;
import com.te.springbootproject.service.EmployeeServiceImp;
import com.te.springbootproject.service.RoleService;

@RestController

public class AdminController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public ResponseEntity<ResponseDto> addEmployee(@RequestBody EmployeeDto employeeDto, @RequestParam String attachment) {
		if (service.addEmployee(employeeDto, attachment) != null) {

			return new ResponseEntity<>(new ResponseDto(true,"employee added successfully",null) ,HttpStatus.OK);
		}

		return new ResponseEntity<>(new ResponseDto(false,"Adding Employee Failed",null), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/addRole")
	public ResponseEntity<ResponseDto> addRole(@RequestBody RoleDto roleDto) {
		if (roleService.addRole(roleDto) != null) {

			return new ResponseEntity<>(new ResponseDto(true, "successfully added", roleService.addRole(roleDto)),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(false, "something went wrong", null), HttpStatus.BAD_REQUEST);
	}
}
