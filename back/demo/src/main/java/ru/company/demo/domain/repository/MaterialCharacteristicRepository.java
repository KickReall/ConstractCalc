package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.Material;
import ru.company.demo.domain.entity.MaterialCharacteristic;

public interface MaterialCharacteristicRepository extends JpaRepository<MaterialCharacteristic, Integer> {
    MaterialCharacteristic findByName(String name);
    MaterialCharacteristic findByMaterialAndWidth(Material material, float width);
    MaterialCharacteristic findFirstByMaterialIdAndWidthAndLengthGreaterThanEqual(int id, float width, float length);
}
