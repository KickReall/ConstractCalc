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
@Table(name = "calculation_state")
public class CalculationState{
    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    @NotBlank
    private String name;

}
