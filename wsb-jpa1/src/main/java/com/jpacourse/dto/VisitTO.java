package com.jpacourse.dto;

import com.jpacourse.persistence.enums.TreatmentType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VisitTO {

    private Long id;
    private String description;
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private Long doctorId;
    private Long patientId;
    private List<TreatmentType> treatmentTypes;
}
