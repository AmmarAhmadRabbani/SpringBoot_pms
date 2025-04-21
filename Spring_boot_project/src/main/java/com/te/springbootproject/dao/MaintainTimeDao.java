package com.te.springbootproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springbootproject.entity.MaintainTime;

public interface MaintainTimeDao extends JpaRepository<MaintainTime, Integer> {
//	public List<MaintainTime> findByEmpId(String empId);
//
	public MaintainTime findByTimeSheetId(int timeSheetId);
}
