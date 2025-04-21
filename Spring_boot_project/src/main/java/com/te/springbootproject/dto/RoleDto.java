package com.te.springbootproject.dto;

import java.util.List;

import com.te.springbootproject.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDto {
	private String rmId;
	private String rmName;
//	private List<Employee> employees;

}
