package ru.company.demo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.company.demo.business.service.CalculationService;
import ru.company.demo.domain.entity.Calculation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calculation")
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping("/{id}")
    public Calculation getCalculationById(@PathVariable int id) {
        return calculationService.getCalculationById(id);
    }
}
