package com.te.springbootproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootproject.dao.RoleDao;
import com.te.springbootproject.dto.RoleDto;
import com.te.springbootproject.entity.Role;
@Service
public class RoleServiceImp implements RoleService {
	@Autowired
	private RoleDao dao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public RoleDto addRole(RoleDto roleDto) {
		Role map=mapper.map(roleDto, Role.class);
		Role saveRole=dao.save(map);
		return mapper.map(saveRole, RoleDto.class);
	}

}
