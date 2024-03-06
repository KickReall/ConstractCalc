package ru.company.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StructuralElementBasement
{
    /**
     * Уникальный идентификатор фундамента
     */
    @Id
    @GeneratedValue(generator = "structural_element_basement_id_seq")
    private int id;

    /**
     * Ссылка на результат {@code Result}
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="results_id")
    private Result result;

    /**
     * Периметр внешних стен
     */
    @Column(name="internal_wall_length")
    private float internalWallLength;

    /**
     * Бетонные сваи
     */
    @Column(name = "concrete_piles")
    private String concretePiles;

    /**
     * Бетон
     */
    @Column(name="concrete")
    private String concrete;
}
