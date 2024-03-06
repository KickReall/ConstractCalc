package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.Opening;

public interface OpeningRepository extends JpaRepository<Opening, Integer> {
}
