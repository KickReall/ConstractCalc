package ru.company.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
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
     * Ссылка на связанные расчеты
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Calculation calculation;

    /**
     * Материал
     */
    @Column(name="material")
    private String material;

    /**
     * Количество
     */
    @Column(name="amount")
    private float amount;

    /**
     * Стоимость
     */
    @Column(name="price")
    private float price;

    /**
     * Единица измерения
     */
    private String measurementUnit;

    /**
     * Общая стоимость
     */
    @Column(name="fullPrice")
    private float fullPrice;
}
