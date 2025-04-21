package com.te.springbootproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootproject.Exception.ResourceNotFoundException;
import com.te.springbootproject.dao.EmployeeDao;
import com.te.springbootproject.dao.ReimbustmentDao;
import com.te.springbootproject.dto.MaintainTimeDto;
import com.te.springbootproject.dto.ReimbustmentDto;
import com.te.springbootproject.dto.ResponseDto;
import com.te.springbootproject.entity.Employee;
import com.te.springbootproject.entity.Reimbustment;

@Service
public class ReimbustmentServiceImp implements ReimbustmentService {

	@Autowired
	private ReimbustmentDao dao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ReimbustmentDto reimbustment(ReimbustmentDto reimbustmentDto) {

		Reimbustment map = mapper.map(reimbustmentDto, Reimbustment.class);
		map.setStatus("pending");

		Employee employee = employeeDao.findByEmpId(reimbustmentDto.getEmpId());
		if (employee != null) {
			map.setEmployee(employee);
			Reimbustment saveReimbustment = dao.save(map);
			return mapper.map(saveReimbustment, ReimbustmentDto.class);

		}
		throw new ResourceNotFoundException("invalid emp id");
	}

	ReimbustmentDto reimbustmentDto;

	@Override
	public List<ReimbustmentDto> getReimbustment(String empId) {

		Optional<Employee> employee = employeeDao.findById(empId);
		if (employee.isEmpty()) {
			throw new ResourceNotFoundException("Employee Id is not found");
		}
		Employee employee2 = employee.get();
		List<Reimbustment> reimbustmentList = employee2.getReimbustmentList();
		List<ReimbustmentDto> reimbustmentDtos = new ArrayList<>();
		reimbustmentList.forEach(n -> {
			reimbustmentDto = new ReimbustmentDto();
			BeanUtils.copyProperties(n, reimbustmentDto);
			reimbustmentDtos.add(reimbustmentDto);

		});
		return reimbustmentDtos;
	}

	@Override
	public ResponseDto updateReimbustment(ReimbustmentDto reimbustmentDto) {
		Reimbustment findByReimbustmentId = dao.findByReimbustmentId(reimbustmentDto.getReimbustmentId());
		if (findByReimbustmentId != null) {

			if (reimbustmentDto.getStatus().equalsIgnoreCase("accept")) {
				findByReimbustmentId.setStatus("accepted");
				dao.save(findByReimbustmentId);
			} else {
				findByReimbustmentId.setStatus("rejected");
				dao.save(findByReimbustmentId);
			}
			return new ResponseDto(Boolean.FALSE, "Status Updated Successfully", findByReimbustmentId.getStatus());
		}
		throw new ResourceNotFoundException("invalid reimbustment id");
		
	}
}
