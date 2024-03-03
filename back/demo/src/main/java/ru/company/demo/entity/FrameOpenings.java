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
public class FrameOpenings {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="structural_element_frame_id")
    private StructuralElementFrame structuralElementFrameId;

    @ManyToOne
    @JoinColumn(name="openings_id")
    private Opening openingId;

    @Column(name="amount")
    private int amount;
}
