package com.te.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.EmployeeLogInDto;
import com.te.springbootproject.dto.MaintainTimeDto;
import com.te.springbootproject.dto.ReimbustmentDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.service.EmployeeService;
import com.te.springbootproject.service.MaintainTimeService;
import com.te.springbootproject.service.ReimbustmentService;

@RestController
public class EmployeeController {

	@Autowired
	ReimbustmentService reimbustmentService;

	@Autowired
	private MaintainTimeService maintainTimeService;

	@Autowired
	EmployeeService service;

	@PostMapping("/logIn")
	public ResponseEntity<ResponseDto> logIn(@RequestBody EmployeeLogInDto employeeLogInDto) {
		EmployeeDto employeeDto = service.logIn(employeeLogInDto);
		if (employeeDto != null) {
			return new ResponseEntity<>(new ResponseDto(true, "login successfull", employeeDto), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(false, "login failed", null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/timesheet")
	public ResponseEntity<ResponseDto> timeSheet(@RequestBody MaintainTimeDto maintainTimeDto) {
		MaintainTimeDto timeSheet = maintainTimeService.timeSheet(maintainTimeDto);
		if (timeSheet != null) {
			return new ResponseEntity<>(new ResponseDto(false, "timesheet maintained", timeSheet), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(true, "Timesheet maitainance failed", null),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getTimesheet/{empId}")
	public ResponseEntity<ResponseDto> getTimeSheet(@PathVariable String empId) {
		List<MaintainTimeDto> timeSheet = maintainTimeService.getTimeSheet(empId);
		if (timeSheet != null) {
			return new ResponseEntity<>(new ResponseDto(false, "successfully feteched", timeSheet), HttpStatus.OK);

		}
		return new ResponseEntity<>(new ResponseDto(true, "not found", null), HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updateTimeSheet/")
	public ResponseEntity<ResponseDto> updateTimeSheet(@RequestBody MaintainTimeDto maintainTimeDto) {
		if (maintainTimeService.updateTimeSheet(maintainTimeDto) != null) {
			return new ResponseEntity<>(
					new ResponseDto(true, "updated successfully", maintainTimeService.updateTimeSheet(maintainTimeDto)),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(false, "not accepted", null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/reimbustment")
	public ResponseEntity<ResponseDto> reimbustment(@RequestBody ReimbustmentDto reimbustmentDto) {
		if (reimbustmentService.reimbustment(reimbustmentDto) != null) {
			return new ResponseEntity<>(new ResponseDto(true, "successfully claimed", null), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(false, "something wrong", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getReimbustment/{empId}")
	public ResponseEntity<ResponseDto> getReimbustment(@PathVariable String empId) {
		List<ReimbustmentDto> reimbustment = reimbustmentService.getReimbustment(empId);
		if (reimbustment != null) {
			return new ResponseEntity<>(new ResponseDto(false, "seccessfully feteched", reimbustment), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(true, "not found", null), HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateReimbustment")
	public ResponseEntity<ResponseDto> updateReimbustment(@RequestBody ReimbustmentDto reimbustmentDto) {
		if (reimbustmentService.updateReimbustment(reimbustmentDto) != null) {
			return new ResponseEntity<>(new ResponseDto(true, "updates successfully",
					reimbustmentService.updateReimbustment(reimbustmentDto)), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(false, "something went wrong", null), HttpStatus.BAD_REQUEST);

	}

}
