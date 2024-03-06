package ru.company.demo.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.company.demo.business.dto.customer.CustomerNameDto;
import ru.company.demo.business.dto.customer.CustomersCardDto;
import ru.company.demo.business.dto.customer.SavedCustomerDto;
import ru.company.demo.business.mapper.CustomerMapper;
import ru.company.demo.domain.entity.Calculation;
import ru.company.demo.domain.entity.Customer;
import ru.company.demo.domain.repository.CalculationRepository;
import ru.company.demo.domain.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CalculationRepository calculationRepository;

    private final CustomerMapper customerMapper;

    public List<CustomerNameDto> getCustomersName() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerNameDto)
                .toList();
    }

    public SavedCustomerDto createCustomer(Customer customer) {
        return customerMapper.toSavedCustomerDto(customerRepository.save(customer));
    }

    public CustomersCardDto getCustomersCardInfo(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        List<Calculation> calculations = calculationRepository.findCalculationByCustomer_Id(customerId);

        return customerMapper.toCustomersCardDto(customer, calculations);
    }
}
