package com.employee.employeespringbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employeespringbootapp.dao.Department;

/**
 * author: kazi
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
