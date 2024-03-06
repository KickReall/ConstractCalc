package ru.company.demo.business.dto.calculation;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculationStateDto {

    @JsonValue
    @NotBlank(message = "Название статуса не может быть пустым")
    private String name;
}
