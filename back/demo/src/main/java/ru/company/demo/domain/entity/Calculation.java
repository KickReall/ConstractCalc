package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculation{

    /**
     * Уникальный идентификатор расчета
     */
    @Id
    @GeneratedValue(generator = "calculation_id_seq")
    private int id;

    /**
     * Ссылка на заказчика {@code Customer}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    /**
     * Адрес строительства
     */
    @Column(name="address_object_constractions")
    private String address;

    /**
     * Номер расчета
     */
    @Column(name="number")
    private int number;

    /**
     * Дата создания расчета
     */
    @Column(name="created_date")
    private LocalDate createdDate;

    /**
     * Список результатов расчета {@code Result}
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="results_id")
    private List<Result> results;

    /**
     * Статус расчета {@code CalculationState}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="calculation_state_id")
    private CalculationState calculationState;

}
