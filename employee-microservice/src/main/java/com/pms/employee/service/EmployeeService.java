package com.pms.employee.service;

import java.util.List;

import com.pms.employee.model.EmployeeCreateDTO;
import com.pms.employee.model.EmployeeDTO;

public interface EmployeeService {
	
	
	public void addEmployee(EmployeeCreateDTO employeeCreateDTO);
	
	public List<EmployeeDTO> getAllEmployees();
	
	public EmployeeDTO getEmployee(int employeeId);
	
	public void updateEmployee(EmployeeCreateDTO employeeCreateDTO, int employeeId);
	
	public void deleteEmployee(int employeeId);

	public String findEmployeeNameByEmployeeId(int employeeId);
	
	

}
