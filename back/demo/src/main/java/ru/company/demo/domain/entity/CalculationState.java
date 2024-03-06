package ru.company.demo.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calculation_state")
public class CalculationState{

    /**
     * Уникальный идентификатор статуса
     */
    @Id
    @GeneratedValue(generator = "calculation_state_id_seq")
    private int id;

    /**
     * Название статуса
     */
    @Column(name="name")
    @NotBlank
    private String name;

}
