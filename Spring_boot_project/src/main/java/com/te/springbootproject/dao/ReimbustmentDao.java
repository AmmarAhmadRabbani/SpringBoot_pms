package com.te.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springbootproject.entity.Reimbustment;


public interface ReimbustmentDao extends JpaRepository<Reimbustment, Integer> {
//	public List<Reimbustment> findByEmpId(String empId);

	public Reimbustment findByReimbustmentId(int reimbustmentId);

	
	

}
