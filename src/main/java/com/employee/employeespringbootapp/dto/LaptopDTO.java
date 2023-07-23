package com.employee.employeespringbootapp.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LaptopDTO implements Serializable {
    private static final long serialVersionUID = 6341253930750761648L;

    @Positive(message = "Laptop Id must be a positive number and > 0")
    private Integer _id;

    @NotNull(message = "laptop brand name must not be null")
    @NotBlank(message = "laptop brand name must not be blank")
    @NotEmpty(message = "laptop brand name must not be Empty")
    private String laptopBrand;

    private String laptopModelName;

    private String processor;

    @Positive(message = "Employee number must be a positive number and > 0")
    private Integer employeeNumber;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getLaptopBrand() {
        return laptopBrand;
    }

    public void setLaptopBrand(String laptopBrand) {
        this.laptopBrand = laptopBrand;
    }

    public String getLaptopModelName() {
        return laptopModelName;
    }

    public void setLaptopModelName(String laptopModelName) {
        this.laptopModelName = laptopModelName;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LaptopDTO(Integer _id, String laptopBrand, String laptopModelName, String processor,
            Integer employeeNumber) {
        this();
        this._id = _id;
        this.laptopBrand = laptopBrand;
        this.laptopModelName = laptopModelName;
        this.processor = processor;
        this.employeeNumber = employeeNumber;
    }

    public LaptopDTO() {
        super();
    }

}
