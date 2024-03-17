package ru.company.demo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.company.demo.business.service.CalculationService;
import ru.company.demo.domain.entity.Calculation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calculation")
@CrossOrigin(origins = "http://localhost:3000")
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping("/{id}")
    public Calculation getCalculationById(@PathVariable int id) {
        return calculationService.getCalculationById(id);
    }
}
