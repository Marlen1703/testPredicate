package com.example.testpredicate;

import com.example.testpredicate.entity.Driver;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DriverDto {

    private Long id;

    private String name;

    private String lastName;

    private String phoneNumber;

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.lastName = driver.getLastName();
        this.phoneNumber = driver.getPhoneNumber();
    }

    public DriverDto() {
    }
}
