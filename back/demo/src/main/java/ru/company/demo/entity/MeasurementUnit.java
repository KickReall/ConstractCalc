package ru.company.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "measurement_units")
public class MeasurementUnit{
    @Id
    @GeneratedValue
    private int id;

    @Column(name="measurement_units_name")
    @NotBlank
    private String measurementUnitsName;

}
