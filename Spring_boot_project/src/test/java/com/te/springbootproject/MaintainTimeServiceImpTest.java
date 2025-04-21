package com.te.springbootproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.te.springbootproject.dao.MaintainTimeDao;
import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.MaintainTimeDto;
import com.te.springbootproject.entity.MaintainTime;
import com.te.springbootproject.service.MaintainTimeServiceImp;

//@SpringBootTest
//public class MaintainTimeServiceImpTest {
//
//	private MockMvc mockMvc;
//
//	@Autowired
//	private MaintainTimeServiceImp maintainTimeServiceImp;
//
//	@MockBean
//	private MaintainTimeDao maintainTimeDao;
//
//	@Test
//	void timeSheetTest() {
//		MaintainTimeDto maintainTimeDto = new MaintainTimeDto(1, "TYC001", "22/11/2022", "hrms", "9:30am", "7:00pm",
//				"pendind");
//		MaintainTime maintainTime = new MaintainTime(1, "TYC001", "22/11/2022", "hrms", "9:30am", "7:00pm", "pendind");
//		when(maintainTimeDao.save(maintainTime)).thenReturn(maintainTime);
//		assertEquals(maintainTimeDto, maintainTimeServiceImp.timeSheet(maintainTimeDto));
//	}
//
//
//		
//		
//
//	}
//
//
