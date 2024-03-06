package ru.company.demo.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "measurement_units")
public class MeasurementUnit{

    /**
     * Уникальный идентификатор единицы измерения
     */
    @Id
    @GeneratedValue(generator = "measurement_units_id_seq")
    private int id;

    /**
     * Название системы измерения
     */
    @Column(name="measurement_units_name")
    @NotBlank
    private String measurementUnitsName;

}
