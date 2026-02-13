package com.foodparadise;

import com.foodparadise.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByPassword(String password);
    List<Customer> findByEmail(String email);

}
