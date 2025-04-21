package com.te.springbootproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springbootproject.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {
	public Employee findByEmpId(String empId);
}
