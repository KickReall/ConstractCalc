package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.MeasurementUnit;

public interface MeasurementUnitsRepository extends JpaRepository<MeasurementUnit, Integer> {
}
