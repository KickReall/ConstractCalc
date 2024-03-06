package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}
