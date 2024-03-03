package ru.company.demo.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material_characteristics")
public class MaterialCharacteristics{
    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="measurement_unit_id")
    private MeasurementUnit measurementUnitId;

    @ManyToOne
    @JoinColumn(name="materials_id")
    private Material materialId;

    @Column(name="length")
    private Float length;
    @Column(name="width")
    private Float width;
    @Column(name="thickness")
    private Float thickness;
    @Column(name="volume")
    private Float volume;
}
