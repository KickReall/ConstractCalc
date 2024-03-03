package ru.company.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StructuralElementBasement
{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="results_id")
    private ResultTable resultId;

    @Column(name="internal_wall_length")
    private float internalWallLength;

    @Column(name = "concrete_piles")
    private String concretePiles;

    @Column(name="concrete")
    private String concrete;
}
