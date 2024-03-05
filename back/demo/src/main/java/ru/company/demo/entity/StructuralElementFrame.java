package ru.company.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StructuralElementFrame {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="results_id")
    private ResultTable resultId;

    @Column(name="amount_floor")
    private int amountFloor;

    @Column(name="floor_number")
    private int floorNumber;

    @Column(name="floor_height")
    private int floorHeight;

    @Column(name="perimeter_of_external_walls")
    private float perimeterOfExternalWalls;

    @Column(name="base_area")
    private float baseArea;

    @Column(name="external_wall_thickness")
    private float externalWallThickness;

    @Column(name="internal_wall_length")
    private float internalWallLength;

    @Column(name="internal_wall_thickness")
    private float internalWallThickness;

    @Column(name="OSB_external_wall")
    private String OSBExternalWall;

    @Column(name="steam_waterproofing_external_wall")
    private String steamWaterproofingExternalWall;

    @Column(name="windscreen_external_wall")
    private String windscreenExternalWall;

    @Column(name="insulation_external_wall")
    private String insulationExternalWall;

    @Column(name="overlap_thickness")
    private String overlapThickness;

    @Column(name="OSB_thickness")
    private String OSBThickness;

    @Column(name="steam_waterproofing_thickness")
    private String steamWaterproofingThickness;

    @Column(name="windscreen_thickness")
    private String windscreenThickness;

    @Column(name="insulation_thickness")
    private String insulationThickness;

    @Column(name="OSB_internal_wall")
    private String OSBInternalWall;

}
