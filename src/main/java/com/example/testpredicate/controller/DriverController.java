package com.example.testpredicate.controller;


import com.example.testpredicate.DriverDto;
import com.example.testpredicate.entity.Driver;
import com.example.testpredicate.repository.DriverRepository;
import com.example.testpredicate.service.DriverService;
import com.querydsl.core.types.Predicate;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    DriverService driverService;



    @GetMapping
    public Page<DriverDto> getAll(
            @QuerydslPredicate(root = Driver.class) Predicate predicate, Pageable pageable){
        return driverService.getAll(predicate,pageable);
    }

    @GetMapping("/{phoneNumber}")
    public void getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber)throws NotFoundException {
         driverService.getById(phoneNumber);
    }



}
