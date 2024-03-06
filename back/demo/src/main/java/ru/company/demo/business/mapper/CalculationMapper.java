package ru.company.demo.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.company.demo.business.dto.calculation.CalculationShortDto;
import ru.company.demo.business.dto.calculation.CalculationStateDto;
import ru.company.demo.domain.entity.Calculation;
import ru.company.demo.domain.entity.CalculationState;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalculationMapper {

    @Mapping(source = "calculationState", target = "state")
    CalculationShortDto toCalculationShortDto(Calculation calculation);

    List<CalculationShortDto> toListOfCalculationShortDto(List<Calculation> calculations);

    CalculationStateDto toCalculationStateDto(CalculationState state);
}
