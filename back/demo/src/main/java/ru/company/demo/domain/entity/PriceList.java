package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price_lists")
public class PriceList{

    /**
     * Уникальный идентификатор прайс-листа
     */
    @Id
    @GeneratedValue(generator = "price_lists_id_seq")
    private int id;

    /**
     * Ссылка на характеристику материала {@code MaterialCharacteristic}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="material_characteristics_id")
    private MaterialCharacteristic materialCharacteristics;

    /**
     * Дата
     */
    @Column(name="date")
    private LocalDate date;

    /**
     * Стоимость закупки
     */
    @Column(name="purhcase_price")
    private float purchasePrice;

    /**
     * Стоимость продажи
     */
    @Column(name="selling_price")
    private float sellingPrice;
}