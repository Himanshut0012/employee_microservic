package com.pms.employee.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.pms.employee.dao.EmployeeDAO;
import com.pms.employee.model.Employee;
import com.pms.employee.model.EmployeeCreateDTO;
import com.pms.employee.model.EmployeeDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeDAO employeeDAO;
	 private final ModelMapper modelMapper;

	@Override
	public void addEmployee(EmployeeCreateDTO employeeCreateDTO) {
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	        Employee employee=modelMapper.map(employeeCreateDTO, Employee.class);
	        System.out.println(employee);
	        this.employeeDAO.save(employee);
		
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees=this.employeeDAO.findAll();
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<EmployeeDTO> employeeDTOs=employees.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class)).toList();
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO getEmployee(int employeeId) {
		Employee employee=this.employeeDAO.getById(employeeId);
		EmployeeDTO employeeDTO=modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

	

	@Override
	public void deleteEmployee(int employeeId) {
		 this.employeeDAO.deleteById(employeeId);
		
	}

	@Override
	public String findEmployeeNameByEmployeeId(int employeeId) {
		return this.employeeDAO.findByEmpId(employeeId).getEmpName();
	}

	@Override
	public void updateEmployee(EmployeeCreateDTO employeeCreateDTO, int employeeId) {
		Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);
				if(employeeOptional.isPresent()) {
					Employee employee= employeeOptional.get();
					employee.setEmpName(employeeCreateDTO.getEmpName());
					employee.setEmailId(employeeCreateDTO.getEmailId());
					employee.setDepartment(employeeCreateDTO.getDepartment());
					employee.setMobileNo(employeeCreateDTO.getMobileNo());
					employeeDAO.save(employee);
					
				}
	}

}
