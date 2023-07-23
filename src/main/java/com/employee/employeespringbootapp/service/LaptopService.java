package com.employee.employeespringbootapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employee.employeespringbootapp.dao.Laptop;
import com.employee.employeespringbootapp.dao.Employee;
import com.employee.employeespringbootapp.dto.LaptopDTO;
import com.employee.employeespringbootapp.repo.LaptopRepo;
import com.employee.employeespringbootapp.util.LaptopUtil;
import com.employee.employeespringbootapp.util.ResponseObject;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private LaptopUtil laptopUtil;

    public ResponseObject getLaptopList() {
        List<Laptop> laptops = laptopRepo.findAll();
        if (!CollectionUtils.isEmpty(laptops)) {
            List<LaptopDTO> laptopDTOs = laptopUtil.createLaptopDTOList(laptops);
            if (!CollectionUtils.isEmpty(laptopDTOs)) {
                return ResponseObject.builder()
                        .setError(false)
                        .setData(laptopDTOs)
                        .build();
            }
        }
        return ResponseObject.builder()
                .setError(true)
                .setMessage("Laptop data not found")
                .build();
    }

    public ResponseObject getLaptopByEmployeeNumber(Employee employee) {
        Integer empployeeNumber = employee.getEmployeeNumber();
        Laptop laptop = laptopRepo.findByEmployeeNumber(empployeeNumber);
        if (laptop != null) {
            return ResponseObject.builder()
                    .setError(false)
                    .setData(laptopUtil.createLaptopDTO(laptop))
                    .build();
        }
        return ResponseObject.builder()
                .setError(true)
                .setMessage("Laptop data not found for the Employee")
                .build();
    }

}
