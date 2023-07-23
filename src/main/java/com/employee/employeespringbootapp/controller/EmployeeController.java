package com.employee.employeespringbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeespringbootapp.service.EmployeeService;
import com.employee.employeespringbootapp.util.ResponseObject;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/fetch-employees", produces = { "application/json" })
    public ResponseEntity<ResponseObject> getEmployees() {
        ResponseObject responseObject = employeeService.getEmployeeList();

        return new ResponseEntity<>(responseObject, new HttpHeaders(),
                responseObject.isError() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping(path = "/fetch-employeesbydeptno", produces = { "application/json" })
    public ResponseEntity<ResponseObject> getEmployeesByDeptNumber(
            @RequestParam(name = "deptno") @Valid Integer deptno) {
        ResponseObject responseObject = employeeService.getEmployeeListByDeptNo(deptno);
        return new ResponseEntity<>(responseObject, new HttpHeaders(),
                responseObject.isError() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
