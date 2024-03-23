package ru.company.demo.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.company.demo.business.dto.incoming.StructuralElementFrameDto;
import ru.company.demo.domain.entity.*;
import ru.company.demo.domain.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import ru.company.demo.business.dto.incoming.StructuralElementFrameDto;
import ru.company.demo.domain.entity.*;
import ru.company.demo.domain.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculationService {

    private final CalculationRepository calculationRepository;
    private final MaterialRepository materialRepository;
    private final MaterialCharacteristicRepository materialCharacteristicRepository;
    private final PriceListRepository priceListRepository;
    private final CalculationStateRepository calculationStateRepository;
    private final CustomerRepository customerRepository;
    private final ResultRepository resultRepository;

    public Calculation getCalculationById(@PathVariable int id) {
        Optional<Calculation> byId = calculationRepository.findById(id);
        return byId.orElseThrow();
    }

    public Calculation calculateFrame(StructuralElementFrameDto dto) {
        StructuralElementFrame frame = dto.getFrame();

        Material woodBoards = materialRepository.findByNameIgnoreCase("Пиломатериал");
        MaterialCharacteristic woodBoardsCharacteristicExternal = materialCharacteristicRepository.findFirstByMaterialIdAndWidthAndLengthGreaterThanEqual(woodBoards.getId(), frame.getExternalWallThickness() * 1000, frame.getFloorHeight());
        MaterialCharacteristic woodBoardsCharacteristicInternal = materialCharacteristicRepository.findFirstByMaterialIdAndWidthAndLengthGreaterThanEqual(woodBoards.getId(), frame.getInternalWallThickness() * 1000, frame.getFloorHeight());
        MaterialCharacteristic woodBoardsCharacteristicThickness = materialCharacteristicRepository.findFirstByMaterialIdAndWidthAndLengthGreaterThanEqual(woodBoards.getId(), frame.getOverlapThickness() * 1000, frame.getFloorHeight());

        float areaExternalWall = frame.getPerimeterOfExternalWalls() * frame.getFloorHeight() * frame.getAmountFloor();
        float areaInternalWall = frame.getInternalWallLength() * frame.getFloorHeight() * frame.getAmountFloor();

        float perimeterOpenings = frame.getOpenings().stream()
                .map(opening -> opening.getWidth() * opening.getHeight())
                .reduce((float) 0, Float::sum);

        List<Result> results = List.of(
                materialToResult(woodBoardsCharacteristicExternal.getName(), frame.getPerimeterOfExternalWalls() * 10 / 6 +
                        frame.getPerimeterOfExternalWalls() * 2 / (woodBoardsCharacteristicExternal.getLength() / 1000) +
                        frame.getPerimeterOfExternalWalls() * frame.getOpenings().size() / (woodBoardsCharacteristicExternal.getLength() / 1000)),
                materialToResult(frame.getOsbExternalWall(), areaExternalWall * 2 + areaExternalWall * 2 / 100 * 15),
                materialToResult(frame.getSteamWaterproofingExternalWall(), areaExternalWall + areaExternalWall / 100 * 15),
                materialToResult(frame.getWindscreenExternalWall(), areaExternalWall + areaExternalWall / 100 * 15),
                materialToResult(frame.getInsulationExternalWall(), areaExternalWall + areaExternalWall / 100 * 10),
                materialToResult(woodBoardsCharacteristicInternal.getName(),
                        perimeterOpenings * frame.getOpenings().size() / (woodBoardsCharacteristicInternal.getLength() / 1000)),
                materialToResult(frame.getOsbInternalWall(), areaInternalWall * 2 + areaInternalWall * 2 / 100 * 15),
                materialToResult(woodBoardsCharacteristicThickness.getName(), frame.getBaseArea() * 7 / 100),
                materialToResult(frame.getOsbThickness(), frame.getBaseArea() * 4 + frame.getBaseArea() * 4 / 100 * 15),
                materialToResult(frame.getSteamWaterproofingThickness(), frame.getBaseArea() + frame.getBaseArea() / 100 * 15),
                materialToResult(frame.getOsbThickness(), frame.getBaseArea() + frame.getBaseArea() / 100 * 15),
                materialToResult(frame.getWindscreenThickness(), frame.getBaseArea() + frame.getBaseArea() / 100 * 15),
                materialToResult(frame.getInsulationThickness(), frame.getBaseArea() + frame.getBaseArea() / 10 - 2)
        );

        Calculation calculation = calculationRepository.save(
                Calculation.builder()
                        .calculationState(calculationStateRepository.findById(1).orElseThrow())
                        .createdDate(LocalDate.now())
                        .customer(customerRepository.findById(dto.getCustomerId()).orElseThrow())
                        .address(dto.getAddress())
                        .build()
        );

        calculation.setResults(resultRepository.saveAll(results.stream().peek(result -> result.setCalculation(calculation)).toList()));
        return calculation;
    }

    private Result materialToResult(String material, float amount) {
        MaterialCharacteristic characteristic = materialCharacteristicRepository.findByName(material);
        return Result.builder()
                .materialCharacteristics(characteristic)
                .material(material)
                .amount(amount)
                .price(priceListRepository.findByMaterialCharacteristics(characteristic).getSellingPrice())
                .measurementUnit(characteristic.getMeasurementUnit().getMeasurementUnitsName())
                .fullPrice(amount * priceListRepository
                        .findByMaterialCharacteristics(characteristic).getSellingPrice())
                .build();
    }
}
