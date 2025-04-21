package com.te.springbootproject.service;

import java.util.List;

import com.te.springbootproject.dto.MaintainTimeDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.entity.MaintainTime;

public interface MaintainTimeService {
	public MaintainTimeDto timeSheet(MaintainTimeDto maintainTimeDto);

	public List<MaintainTimeDto> getTimeSheet(String empId);
	public ResponseDto updateTimeSheet(MaintainTimeDto maintainTimeDto);

	
}
