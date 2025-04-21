package com.te.springbootproject.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean error;
	private String message;
	private Object data;

}
