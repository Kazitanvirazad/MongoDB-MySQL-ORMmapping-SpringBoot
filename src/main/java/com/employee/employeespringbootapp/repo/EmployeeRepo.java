package com.employee.employeespringbootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employeespringbootapp.dao.Department;
import com.employee.employeespringbootapp.dao.Employee;

/**
 * author: kazi
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByDepartment(Department department);

}
