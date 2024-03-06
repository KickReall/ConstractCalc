package ru.company.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.demo.domain.entity.PriceList;

public interface PriceListRepository extends JpaRepository<PriceList, Integer> {
}
