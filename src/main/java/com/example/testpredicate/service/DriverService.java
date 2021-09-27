package com.example.testpredicate.service;
import com.example.testpredicate.DriverDto;
import com.example.testpredicate.entity.Driver;
import com.example.testpredicate.entity.QDriver;
import com.example.testpredicate.repository.DriverRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public Page<DriverDto> getAll(Predicate predicate, Pageable pageable){
        final QDriver qDriver = QDriver.driver;
        final BooleanBuilder builder = new BooleanBuilder(predicate);
        builder.and(qDriver.isNotNull());

        return driverRepository.findAll(builder.getValue(),pageable).map(DriverDto::new);
    }


    public void getById(String phoneNumber){
        Optional<Driver> driver=driverRepository.findByPhoneNumber(phoneNumber);

    }
}
