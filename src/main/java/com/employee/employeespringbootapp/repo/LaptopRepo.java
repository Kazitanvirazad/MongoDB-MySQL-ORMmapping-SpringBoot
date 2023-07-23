package com.employee.employeespringbootapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.employee.employeespringbootapp.dao.Laptop;

public interface LaptopRepo extends MongoRepository<Laptop, Integer> {

    @Query("{ 'employeeNumber' : ?0 }")
    Laptop findByEmployeeNumber(Integer employeeNumber);

}
