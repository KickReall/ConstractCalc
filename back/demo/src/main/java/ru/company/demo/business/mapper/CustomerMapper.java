package ru.company.demo.business.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.company.demo.business.dto.customer.CustomerNameDto;
import ru.company.demo.business.dto.customer.CustomersCardDto;
import ru.company.demo.business.dto.customer.SavedCustomerDto;
import ru.company.demo.domain.entity.Calculation;
import ru.company.demo.domain.entity.Customer;

import java.util.List;

@Mapper(componentModel = "spring")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CustomerMapper {

    protected CalculationMapper calculationMapper;

    public abstract CustomerNameDto toCustomerNameDto(Customer customer);

    public abstract SavedCustomerDto toSavedCustomerDto(Customer customer);

    @Mapping(target = "calculations", expression = "java(calculationMapper.toListOfCalculationShortDto(calculations))")
    public abstract CustomersCardDto toCustomersCardDto(Customer customer, List<Calculation> calculations);
}
