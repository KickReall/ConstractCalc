package ru.company.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
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
    @JsonIgnore
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
    @GenericGenerator(name = "calculation_number_seq")
    private int number;

    /**
     * Дата создания расчета
     */
    @Column(name="created_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate createdDate;

    /**
     * Список результатов расчета {@code Result}
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "calculation_id")
    private List<Result> results;

    /**
     * Статус расчета {@code CalculationState}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="calculation_state_id")
    private CalculationState calculationState;

}
