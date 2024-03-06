package ru.company.demo.domain.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material_characteristics")
public class MaterialCharacteristic {

    /**
     * Уникальный идентификатор характеристики материала
     */
    @Id
    @GeneratedValue(generator = "material_characteristics_id_seq")
    private int id;

    /**
     * Название характеристики
     */
    @Column(name="name")
    private String name;

    /**
     * Ссылка на единицу измерения {@code MeasurementUnit}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="measurement_unit_id")
    private MeasurementUnit measurementUnit;

    /**
     * Ссылка на материал {@code Material}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="materials_id")
    private Material material;

    /**
     * Длина
     */
    @Column(name="length")
    private float length;

    /**
     * Ширина
     */
    @Column(name="width")
    private float width;

    /**
     * Толщина
     */
    @Column(name="thickness")
    private float thickness;

    /**
     * Объем
     */
    @Column(name="volume")
    private float volume;
}
