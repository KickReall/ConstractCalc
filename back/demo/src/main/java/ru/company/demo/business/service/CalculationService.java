package ru.company.demo.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.company.demo.domain.entity.Calculation;
import ru.company.demo.domain.repository.CalculationRepository;

@Service
@RequiredArgsConstructor
public class CalculationService {

    private final CalculationRepository calculationRepository;

    public Calculation getCalculationById(@PathVariable int id) {
        return calculationRepository.findById(id).orElseThrow();
    }
}
