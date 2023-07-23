package com.employee.employeespringbootapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.employeespringbootapp.dao.Employee;
import com.employee.employeespringbootapp.dto.EmployeeDTO;
import com.employee.employeespringbootapp.dto.LaptopDTO;
import com.employee.employeespringbootapp.service.LaptopService;

@Component
public class EmployeeUtil {

    @Autowired
    private DepartmentUtil departmentUtil;

    @Autowired
    private LaptopService laptopService;

    public EmployeeDTO createEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeNumber(employee.getEmployeeNumber());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setDesignation(employee.getDesignation());
        employeeDTO.setCommission(employee.getCommission());
        employeeDTO.setHireDate(employee.getHireDate());
        employeeDTO.setManager(employee.getManager());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setDepartment(departmentUtil.createDepartmentDTO(employee.getDepartment()));
        ResponseObject laptopObj = laptopService.getLaptopByEmployeeNumber(employee);
        if (!laptopObj.isError())
            employeeDTO.setAssignedLaptop((LaptopDTO) laptopObj.getData());
        return employeeDTO;
    }

    public List<EmployeeDTO> createEmployeeDTOList(List<Employee> employees) {
        List<EmployeeDTO> eList = new ArrayList<>();
        for (Employee emp : employees) {
            EmployeeDTO employeeDTO = createEmployeeDTO(emp);
            eList.add(employeeDTO);
        }
        return eList;
    }
}
