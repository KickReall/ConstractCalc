package ru.company.demo.business.dto.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerNameDto {

    @NotBlank(message = "Идентификатор не может быть пустым")
    private Integer id;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Отчество не может быть пустым")
    private String secondName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;
}
