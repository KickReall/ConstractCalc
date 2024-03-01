package ru.company.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class MeasurementUnit extends AbstractEntity {

    @Column(name="measurement_units_name")
    @NotBlank
    private String measurementUnitsName;

}
