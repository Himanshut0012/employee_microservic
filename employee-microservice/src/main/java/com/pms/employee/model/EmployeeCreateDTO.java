package com.pms.employee.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class EmployeeCreateDTO {
	private String empName ;
	private String department;
	private String emailId ;
	private String mobileNo;
	@JsonIgnore
	private String recordStatus = "1";
}
