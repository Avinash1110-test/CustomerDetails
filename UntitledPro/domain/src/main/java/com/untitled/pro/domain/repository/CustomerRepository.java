package com.untitled.pro.domain.repository;

import com.untitled.pro.domain.entity.Customer;
import com.untitled.pro.domain.entity.QCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, QuerydslPredicateExecutor<Customer>, QuerydslBinderCustomizer<QCustomer> {
}
