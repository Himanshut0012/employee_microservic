package com.pms.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.employee.model.EmployeeCreateDTO;
import com.pms.employee.model.EmployeeDTO;
import com.pms.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v1/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping("/")
	public String addEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
		this.employeeService.addEmployee(employeeCreateDTO);
		return "employee added:";
	}

	@GetMapping("/")
	public List<EmployeeDTO> getAllEmployees() {
		return this.employeeService.getAllEmployees();
	}

	@PutMapping("/{employeeId}")
	public void updateEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO,@PathVariable int employeeId) {
		this.employeeService.updateEmployee(employeeCreateDTO, employeeId);
	}

	@GetMapping("/{employeeId}")
	public EmployeeDTO getEmployeeById(@PathVariable int employeeId) {
		return this.employeeService.getEmployee(employeeId);
	}

	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		this.employeeService.deleteEmployee(employeeId);
	}

	@GetMapping("/find/{employeeId}")
	public String findEmployeeNameByEmployeeId(@PathVariable int employeeId) {
		System.out.println(employeeId);
		return this.employeeService.findEmployeeNameByEmployeeId(employeeId);
	}
}
