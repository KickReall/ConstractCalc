package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.Calculation;

import java.util.List;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {
    List<Calculation> findCalculationByCustomer_Id(int id);
}
