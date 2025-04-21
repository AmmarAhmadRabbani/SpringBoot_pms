package com.te.springbootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReimbustmentDto {

	private int reimbustmentId;
	private String empId;
	private String date;
	private String place;
	private String purpose;
	private String amount;
	private String status;
	// private Employee employee;
}
