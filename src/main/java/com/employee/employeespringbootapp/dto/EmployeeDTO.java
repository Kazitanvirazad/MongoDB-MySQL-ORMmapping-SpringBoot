package com.employee.employeespringbootapp.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 7411716392582938976L;

    @NotNull(message = "Employee Number must not be null")
    @NotBlank(message = "Employee Number must not be blank")
    @NotEmpty(message = "Employee Number must not be Empty")
    private Integer employeeNumber;

    @NotNull(message = "Employee Name must not be null")
    @NotBlank(message = "Employee Name must not be blank")
    @NotEmpty(message = "Employee Name must not be Empty")
    private String employeeName;

    private String designation;

    private Integer manager;

    private Date hireDate;

    private Integer salary;

    private Integer commission;

    private DepartmentDTO department;

    private LaptopDTO assignedLaptop;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(Integer employeeNumber, String employeeName, String designation, Integer manager, Date hireDate,
            Integer salary, Integer commission, DepartmentDTO department, LaptopDTO assignedLaptop) {
        this();
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.designation = designation;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.department = department;
        this.assignedLaptop = assignedLaptop;
    }

    public LaptopDTO getAssignedLaptop() {
        return assignedLaptop;
    }

    public void setAssignedLaptop(LaptopDTO assignedLaptop) {
        this.assignedLaptop = assignedLaptop;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

}
