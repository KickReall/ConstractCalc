package ru.company.demo.business.dto.calculation;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculationShortDto {

    @NotBlank(message = "Идентификатор не может быть пустым")
    private Integer id;

    @NotBlank(message = "Номер не может быть пустым")
    private Integer number;

    @NotBlank(message = "Дата создания - обязательное поле")
    private LocalDate createdDate;

    @NotBlank(message = "Статус не может быть пустым")
    private CalculationStateDto state;

    @NotBlank(message = "Адрес не может быть пустым")
    private String address;
}
