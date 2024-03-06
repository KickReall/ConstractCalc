package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.StructuralElementBasement;

public interface StructuralElementBasementRepository extends JpaRepository<StructuralElementBasement, Integer> {
}
