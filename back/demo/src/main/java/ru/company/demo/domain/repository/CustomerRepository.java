package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
