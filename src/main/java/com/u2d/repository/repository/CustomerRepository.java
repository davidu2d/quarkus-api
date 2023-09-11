package com.u2d.repository.repository;

import com.u2d.repository.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface CustomerRepository extends PanacheRepository<Customer> {
}
