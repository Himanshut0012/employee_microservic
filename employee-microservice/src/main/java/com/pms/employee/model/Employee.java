package com.pms.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(updatable = false,nullable = false)
		private Integer empId ;
	    private String empName ;
	    private String emailId ;
	    private String mobileNo;
	    private String department;
	    private String createdBy;
	    private Date createdDate;
	    private String lastUpdatedBy;
	    private Date lastUpdatedDate;
	    private String recordStatus;

}
