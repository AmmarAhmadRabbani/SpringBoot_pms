package com.te.springbootproject.dto;

import com.te.springbootproject.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaintainTimeDto {
	private int timeSheetId;
	private String empId;
	private String date;
	private String project;
	private String logInTime;
	private String logOutTime;
	private String status;
	//private Employee employee;

}
