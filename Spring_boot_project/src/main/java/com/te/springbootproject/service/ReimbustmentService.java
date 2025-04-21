package com.te.springbootproject.service;

import java.util.List;

import com.te.springbootproject.dto.ReimbustmentDto;
import com.te.springbootproject.dto.ResponseDto;

public interface ReimbustmentService {
	public ReimbustmentDto reimbustment(ReimbustmentDto reimbustmentDto);
	public List<ReimbustmentDto> getReimbustment(String empId);
	public ResponseDto updateReimbustment(ReimbustmentDto reimbustmentDto);
	

}
