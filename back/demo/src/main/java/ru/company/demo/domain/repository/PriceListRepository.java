package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.MaterialCharacteristic;
import ru.company.demo.domain.entity.PriceList;

public interface PriceListRepository extends JpaRepository<PriceList, Integer> {
    PriceList findByMaterialCharacteristics(MaterialCharacteristic characteristic);
}
