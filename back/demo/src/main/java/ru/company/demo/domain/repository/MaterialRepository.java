package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
