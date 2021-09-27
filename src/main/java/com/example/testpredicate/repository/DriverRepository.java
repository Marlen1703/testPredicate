package com.example.testpredicate.repository;

import com.example.testpredicate.entity.Driver;
import com.example.testpredicate.entity.QDriver;
import com.querydsl.core.types.Predicate;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>,
        QuerydslPredicateExecutor<Driver>, QuerydslBinderCustomizer<QDriver>
{

    @Override
    default void customize(@NotNull QuerydslBindings bindings, @NotNull QDriver driver) {
    }
    Page<Driver> findAll(Predicate predicate, Pageable pageable);


    Optional<Driver> findByPhoneNumber(String phoneNumber);

}
