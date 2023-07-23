package com.employee.employeespringbootapp.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(value = "laptop")
public class Laptop {

    @Id
    private Integer _id;
    private String laptopBrand;
    private String laptopModelName;
    private String processor;
    private Integer employeeNumber;

    public Integer getEmpployeeNumber() {
        return employeeNumber;
    }

    public void setEmpployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getLaptopId() {
        return _id;
    }

    public void setLaptopId(Integer _id) {
        this._id = _id;
    }

    public String getLaptopBrand() {
        return laptopBrand;
    }

    public void setLaptopBrand(String laptopBrand) {
        this.laptopBrand = laptopBrand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getLaptopModelName() {
        return laptopModelName;
    }

    public void setLaptopModelName(String laptopModelName) {
        this.laptopModelName = laptopModelName;
    }

    public Laptop(Integer _id, String laptopBrand, String laptopModelName, String processor, Integer employeeNumber) {
        this();
        this._id = _id;
        this.laptopBrand = laptopBrand;
        this.laptopModelName = laptopModelName;
        this.processor = processor;
        this.employeeNumber = employeeNumber;
    }

    public Laptop() {
        super();
    }
}
