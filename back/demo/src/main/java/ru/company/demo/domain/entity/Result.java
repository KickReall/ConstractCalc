package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "results")
public class Result {

    /**
     * Уникальный идентификатор результата
     */
    @Id
    @GeneratedValue(generator = "results_id_seq")
    private int id;

    /**
     * Ссылка на характеристику материала {@code MaterialCharacteristic}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="material_characteristics_id")
    private MaterialCharacteristic materialCharacteristics;

    /**
     * Материал
     */
    @Column(name="material")
    private String material;

    /**
     * Количество
     */
    @Column(name="amount")
    private int amount;

    /**
     * Стоимость
     */
    @Column(name="price")
    private float price;

    /**
     * Ссылка на единицу измерения {@code MeasurementUnit}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="measurement_unit")
    private MeasurementUnit measurementUnit;

    /**
     * Общая стоимость
     */
    @Column(name="fullPrice")
    private float fullPrice;
}
