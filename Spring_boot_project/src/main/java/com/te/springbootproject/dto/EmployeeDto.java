package com.te.springbootproject.dto;

import java.util.List;

import com.te.springbootproject.entity.MaintainTime;
import com.te.springbootproject.entity.Reimbustment;
import com.te.springbootproject.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private String empId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private Role role;
//	private List<MaintainTime> maintainTime;
//	private List<Reimbustment> reimbustment;

}
