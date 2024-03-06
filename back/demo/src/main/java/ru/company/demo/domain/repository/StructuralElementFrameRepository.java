package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.StructuralElementFrame;

public interface StructuralElementFrameRepository extends JpaRepository<StructuralElementFrame, Integer> {
}
