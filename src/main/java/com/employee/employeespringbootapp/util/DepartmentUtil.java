package com.employee.employeespringbootapp.util;

import org.springframework.stereotype.Component;

import com.employee.employeespringbootapp.dao.Department;
import com.employee.employeespringbootapp.dto.DepartmentDTO;

@Component
public class DepartmentUtil {

    public DepartmentDTO createDepartmentDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setLocation(department.getLocation());
        departmentDTO.setDepartmentName(department.getDepartmentName());
        departmentDTO.setDepartmentNumber(department.getDepartmentNumber());
        return departmentDTO;
    }
}
