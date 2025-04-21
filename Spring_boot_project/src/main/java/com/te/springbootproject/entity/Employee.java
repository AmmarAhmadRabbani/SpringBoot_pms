package com.te.springbootproject.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "empId")
public class Employee implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String empId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "employee")
	private List<MaintainTime> maintainTimesList;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Reimbustment> reimbustmentList;

}
