package ru.company.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "results")
public class ResultTable{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="material_characteristics_id")
    private MaterialCharacteristics materialCharacteristicsId;

    @Column(name="material")
    private String material;
    @Column(name="amount")
    private Integer amount;
    @Column(name="price")
    private Float price;

    @ManyToOne
    @JoinColumn(name="measurement_unit")
    private MeasurementUnit measurementUnitId;

    @Column(name="fullPrice")
    private Float fullPrice;

}
