package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public final class VisitMapper {

    private VisitMapper() {}

    public static VisitTO mapToTO(VisitEntity visitEntity) {
        if (visitEntity == null) return null;
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctorFirstName(visitEntity.getDoctor().getFirstName());
        visitTO.setDoctorLastName(visitEntity.getDoctor().getLastName());
        if (visitEntity.getMedicalTreatments() != null) {
            visitTO.setTreatmentTypes(visitEntity.getMedicalTreatments().stream().map(MedicalTreatmentEntity::getType).collect(Collectors.toList()));
        }
        else {
            visitTO.setTreatmentTypes(new ArrayList<>());
        }
        return visitTO;
    }

    public static VisitEntity mapToEntity(VisitTO visitTO) {
        if (visitTO == null) return null;
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        return visitEntity;
    }
}
