package com.employee.employeespringbootapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.employeespringbootapp.dao.Laptop;
import com.employee.employeespringbootapp.dto.LaptopDTO;

@Component
public class LaptopUtil {

    public LaptopDTO createLaptopDTO(Laptop laptop) {
        LaptopDTO laptopDTO = new LaptopDTO();
        laptopDTO.setEmployeeNumber(laptop.getEmpployeeNumber());
        laptopDTO.setLaptopBrand(laptop.getLaptopBrand());
        laptopDTO.setLaptopModelName(laptop.getLaptopModelName());
        laptopDTO.setProcessor(laptop.getProcessor());
        laptopDTO.set_id(laptop.getLaptopId());
        return laptopDTO;
    }

    public List<LaptopDTO> createLaptopDTOList(List<Laptop> laptop) {
        List<LaptopDTO> laptopDTOs = new ArrayList<>();

        for (Laptop lp : laptop) {
            LaptopDTO laptopDTO = createLaptopDTO(lp);
            laptopDTOs.add(laptopDTO);
        }
        return laptopDTOs;
    }
}
