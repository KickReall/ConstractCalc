package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.MaterialCharacteristic;

public interface MaterialCharacteristicRepository extends JpaRepository<MaterialCharacteristic, Integer> {
}
