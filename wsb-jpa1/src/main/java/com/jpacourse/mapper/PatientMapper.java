package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientMapper {

    private PatientMapper() {}

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        VisitMapper visitMapper = new VisitMapper();
        if (patientEntity == null) return null;
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        patientTO.setVisits(patientEntity.getVisits().stream().map(visitMapper::mapToTO).collect(Collectors.toList()));
        patientTO.setAnnualIncome(patientEntity.getAnnualIncome());
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        VisitMapper visitMapper = new VisitMapper();
        if (patientTO == null) return null;
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAddress(AddressMapper.mapToEntity(patientTO.getAddress()));
        patientEntity.setVisits(patientTO.getVisits().stream().map(visitMapper::mapToEntity).collect(Collectors.toList()));
        patientEntity.setAnnualIncome(patientTO.getAnnualIncome());
        return patientEntity;
    }
}
