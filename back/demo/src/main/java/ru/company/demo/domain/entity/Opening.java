package ru.company.demo.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "openings")
public class Opening{

    /**
     * Уникальный идентификатор проема
     */
    @Id
    @GeneratedValue(generator = "openings_id_seq")
    private int id;

    /**
     * Тип проема
     */
    @Column(name="type")
    @NotBlank
    private String type;

    /**
     * Ширина проема
     */
    @Column(name="width")
    @NotBlank
    private float width;

    /**
     * Высота проема
     */
    @Column(name="height")
    @NotBlank
    private float height;

    /**
     * Связанные элементы каркаса {@code StructuralElementFrame}
     */
    @ManyToMany(mappedBy = "openings")
    List<StructuralElementFrame> frames;
}
