package com.employee.employeespringbootapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employee.employeespringbootapp.dao.Department;
import com.employee.employeespringbootapp.dao.Employee;
import com.employee.employeespringbootapp.dto.EmployeeDTO;
import com.employee.employeespringbootapp.repo.DepartmentRepo;
import com.employee.employeespringbootapp.repo.EmployeeRepo;
import com.employee.employeespringbootapp.util.EmployeeUtil;
import com.employee.employeespringbootapp.util.ResponseObject;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeUtil employeeUtil;

    public ResponseObject getEmployeeList() {
        List<Employee> employees = employeeRepo.findAll();
        if (!CollectionUtils.isEmpty(employees)) {
            List<EmployeeDTO> eDtos = employeeUtil.createEmployeeDTOList(employees);
            if (!CollectionUtils.isEmpty(eDtos)) {
                return ResponseObject.builder()
                        .setError(false)
                        .setData(eDtos)
                        .build();
            }
        }
        return ResponseObject.builder()
                .setError(true)
                .setMessage("Employee data not found")
                .build();
    }

    public ResponseObject getEmployeeListByDeptNo(Integer deptno) {
        Optional<Department> optional = departmentRepo.findById(deptno);
        if (optional.isPresent()) {
            Department department = optional.get();
            List<Employee> employees = employeeRepo.findAllByDepartment(department);
            if (!CollectionUtils.isEmpty(employees)) {
                return ResponseObject.builder()
                        .setError(false)
                        .setData(employeeUtil.createEmployeeDTOList(employees))
                        .build();
            }
        }
        return ResponseObject.builder()
                .setError(true)
                .setMessage("Employee data not found")
                .build();
    }
}
