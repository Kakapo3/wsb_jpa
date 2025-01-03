package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistence.entity.DoctorEntity;

import javax.print.Doc;
import java.util.stream.Collectors;

public final class DoctorMapper {

    private DoctorMapper() {}

    public static DoctorTO mapToTO(final DoctorEntity DoctorEntity) {
        if (DoctorEntity == null) return null;
        final DoctorTO DoctorTO = new DoctorTO();
        DoctorTO.setId(DoctorEntity.getId());
        DoctorTO.setFirstName(DoctorEntity.getFirstName());
        DoctorTO.setLastName(DoctorEntity.getLastName());
        DoctorTO.setTelephoneNumber(DoctorEntity.getTelephoneNumber());
        DoctorTO.setEmail(DoctorEntity.getEmail());
        DoctorTO.setDoctorNumber(DoctorEntity.getDoctorNumber());
        DoctorTO.setSpecialization(DoctorEntity.getSpecialization());
        return DoctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO DoctorTO) {
        if (DoctorTO == null) return null;
        final DoctorEntity DoctorEntity = new DoctorEntity();
        DoctorEntity.setFirstName(DoctorTO.getFirstName());
        DoctorEntity.setLastName(DoctorTO.getLastName());
        DoctorEntity.setTelephoneNumber(DoctorTO.getTelephoneNumber());
        DoctorEntity.setEmail(DoctorTO.getEmail());
        DoctorEntity.setDoctorNumber(DoctorTO.getDoctorNumber());
        DoctorEntity.setSpecialization(DoctorTO.getSpecialization());
        return DoctorEntity;
    }
}
