package ru.company.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price_lists")
public class PriceList{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="material_characteristics_id")
    private MaterialCharacteristics materialCharacteristicsId;

    @Column(name="date")
    private Date date;

    @Column(name="purhcase_price")
    private float purchasePrice;

    @Column(name="selling_price")
    private float sellingPrice;
}