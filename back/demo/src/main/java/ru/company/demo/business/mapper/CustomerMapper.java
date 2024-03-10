package ru.company.demo.business.mapper;

import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.company.demo.business.dto.customer.CustomerNameDto;
import ru.company.demo.business.dto.customer.CustomersCardDto;
import ru.company.demo.business.dto.customer.SavedCustomerDto;
import ru.company.demo.domain.entity.Calculation;
import ru.company.demo.domain.entity.Customer;

import java.util.List;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class CustomerMapper {

    protected CalculationMapper calculationMapper;

    @Autowired
    public void setCalculationMapper(CalculationMapper calculationMapper) {
        this.calculationMapper = calculationMapper;
    }

    public abstract CustomerNameDto toCustomerNameDto(Customer customer);

    public abstract SavedCustomerDto toSavedCustomerDto(Customer customer);

    @Mapping(target = "calculations", expression = "java(calculationMapper.toListOfCalculationShortDto(calculations))")
    public abstract CustomersCardDto toCustomersCardDto(Customer customer, List<Calculation> calculations);
}
