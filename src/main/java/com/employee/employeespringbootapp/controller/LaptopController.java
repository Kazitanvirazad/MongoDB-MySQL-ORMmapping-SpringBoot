package com.employee.employeespringbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeespringbootapp.service.LaptopService;
import com.employee.employeespringbootapp.util.ResponseObject;

@RestController
@RequestMapping(path = "/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping(path = "/fetch-laptops", produces = { "application/json" })
    public ResponseEntity<ResponseObject> getLaptopList() {
        ResponseObject responseObject = laptopService.getLaptopList();

        return new ResponseEntity<>(responseObject, new HttpHeaders(),
                responseObject.isError() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
