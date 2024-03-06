package ru.company.demo.business.dto.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.company.demo.business.dto.calculation.CalculationShortDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomersCardDto {

    @NotBlank(message = "Идентификатор не может быть пустым")
    private Integer id;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Отчество не может быть пустым")
    private String secondName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    @NotBlank(message = "Номер телефона не может быть пустым")
    private String phone;

    @NotBlank(message = "Адрес не может быть пустым")
    private String address;

    private List<CalculationShortDto> calculations;
}
