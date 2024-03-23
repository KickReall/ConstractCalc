package ru.company.demo.business.dto.incoming;

import lombok.*;
import ru.company.demo.domain.entity.StructuralElementFrame;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StructuralElementFrameDto {

    @NonNull
    private Integer customerId;

    @NonNull
    private String address;

    @NonNull
    private StructuralElementFrame frame;
}
