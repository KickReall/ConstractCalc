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
public class Calculation{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="address_object_constractions")
    private String address;

    @Column(name="number")
    private int number;

    @Column(name="created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name="results_id")
    private ResultTable result;

    @ManyToOne
    @JoinColumn(name="calculation_state_id")
    private CalculationState calculationStateId;

}
