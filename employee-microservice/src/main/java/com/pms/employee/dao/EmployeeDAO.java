package com.pms.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.employee.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

   public Employee findByEmpId(int employeeId);
}
