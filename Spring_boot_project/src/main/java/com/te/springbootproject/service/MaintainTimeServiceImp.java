package com.te.springbootproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootproject.Exception.ResourceNotFoundException;
import com.te.springbootproject.dao.EmployeeDao;
import com.te.springbootproject.dao.MaintainTimeDao;
import com.te.springbootproject.dto.MaintainTimeDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.entity.Employee;
import com.te.springbootproject.entity.MaintainTime;

@Service
public class MaintainTimeServiceImp implements MaintainTimeService {
	@Autowired
	private MaintainTimeDao dao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public MaintainTimeDto timeSheet(MaintainTimeDto maintainTimeDto) {
		MaintainTime map = mapper.map(maintainTimeDto, MaintainTime.class);
		map.setStatus("pending");

		Employee employee = employeeDao.findByEmpId(maintainTimeDto.getEmpId());
		if (employee != null) {
			map.setEmployee(employee);

			MaintainTime saveMaintainTime = dao.save(map);
			return mapper.map(saveMaintainTime, MaintainTimeDto.class);

		}
		throw new ResourceNotFoundException("invalid emp id");

	}

	MaintainTimeDto maintainTimeDto;

	@Override
	public List<MaintainTimeDto> getTimeSheet(String empId) {
		Optional<Employee> employee = employeeDao.findById(empId);
		if (employee.isEmpty()) {
			throw new ResourceNotFoundException("Employee Id not exist");
		}
		Employee employee2 = employee.get();
		List<MaintainTime> maintainTimesList = employee2.getMaintainTimesList();
		List<MaintainTimeDto> maintainTimeDtos = new ArrayList();
		maintainTimesList.forEach(n -> {
			maintainTimeDto = new MaintainTimeDto();
			BeanUtils.copyProperties(n, maintainTimeDto);
			maintainTimeDtos.add(maintainTimeDto);
		});

		return maintainTimeDtos;
	}

	@Override
	public ResponseDto updateTimeSheet(MaintainTimeDto maintainTimeDto) {
		MaintainTime findByTimeSheetId = dao.findByTimeSheetId(maintainTimeDto.getTimeSheetId());
		if (findByTimeSheetId!=null) {

			if (maintainTimeDto.getStatus().equalsIgnoreCase("accept")) {
				findByTimeSheetId.setStatus("accepted");
				dao.save(findByTimeSheetId);
			} else {
				findByTimeSheetId.setStatus("rejected");
				dao.save(findByTimeSheetId);
			}
			return new ResponseDto(Boolean.FALSE, "status updated", findByTimeSheetId.getStatus());
		}
		throw new ResourceNotFoundException("invalid timesheet id");
	}
	
}
