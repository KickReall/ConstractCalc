package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.CalculationState;

public interface CalculationStateRepository extends JpaRepository<CalculationState, Integer> {
    CalculationState findByNameIgnoreCase(String name);
}
