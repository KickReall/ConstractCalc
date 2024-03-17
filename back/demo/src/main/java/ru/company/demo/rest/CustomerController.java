package ru.company.demo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.company.demo.business.dto.customer.CustomerNameDto;
import ru.company.demo.business.dto.customer.CustomersCardDto;
import ru.company.demo.business.dto.customer.SavedCustomerDto;
import ru.company.demo.business.service.CustomerService;
import ru.company.demo.domain.entity.Customer;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public SavedCustomerDto createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<CustomerNameDto> getCustomersName() {
        return customerService.getCustomersName();
    }

    @GetMapping("/{customerId}")
    public CustomersCardDto getCustomersCardInfo(@PathVariable int customerId){
        return customerService.getCustomersCardInfo(customerId);
    }
}
