package com.employee.employeespringbootapp.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DepartmentDTO implements Serializable {

    private static final long serialVersionUID = 6603215683358092903L;

    @NotNull(message = "Department Number must not be null")
    @NotBlank(message = "Department Number must not be blank")
    @NotEmpty(message = "Department Number must not be Empty")
    private Integer departmentNumber;

    @NotNull(message = "Department Name must not be null")
    @NotBlank(message = "Department Name must not be blank")
    @NotEmpty(message = "Department Name must not be Empty")
    private String departmentName;

    private String location;

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DepartmentDTO() {
        super();
    }

    public DepartmentDTO(Integer departmentNumber, String departmentName, String location) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.location = location;
    }

}
