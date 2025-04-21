package com.te.springbootproject.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.te.springbootproject.Exception.ResourceNotFoundException;
import com.te.springbootproject.dao.EmployeeDao;
import com.te.springbootproject.dto.EmployeeDto;
import com.te.springbootproject.dto.EmployeeLogInDto;

import com.te.springbootproject.entity.Employee;

import antlr.collections.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto, String attachment) {

//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("ammarthegenious@gmail.com");
//		message.setTo(employeeDto.getEmail());
//		message.setText("Dear Employee:" + employeeDto.getFirstName() + employeeDto.getLastName() + "\n"
//				+ "employee id is:" + employeeDto.getEmpId() + "\n" + "password is :" + employeeDto.getPassword() + "\n"
//				+ "Please login with your empId and password");
//		message.setSubject("find your credentials below");
//
//		javaMailSender.send(message);
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("ammarthegenious@gmail.com");
			mimeMessageHelper.setTo(employeeDto.getEmail());
			mimeMessageHelper.setText("Dear Employee:" + employeeDto.getFirstName() + employeeDto.getLastName() + "\n"
					+ "employee id is:" + employeeDto.getEmpId() + "\n" + "password is :" + employeeDto.getPassword()
					+ "\n" + "Please login with your empId and password");
			mimeMessageHelper.setSubject("find your attachment with all credentails"   );

			FileSystemResource fileSystemResource = new FileSystemResource(attachment);

			mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		Employee mapEmployee = mapper.map(employeeDto, Employee.class);

		Employee save = dao.save(mapEmployee);
		return mapper.map(save, EmployeeDto.class);
	}

	@Override
	public EmployeeDto logIn(EmployeeLogInDto employeeLogInDto) {
		Employee findByEmpId = dao.findByEmpId(employeeLogInDto.getEmpId());

		if (findByEmpId != null) {
			return mapper.map(findByEmpId, EmployeeDto.class);
		}
		throw new ResourceNotFoundException("wrong credentials:");
	}

}
