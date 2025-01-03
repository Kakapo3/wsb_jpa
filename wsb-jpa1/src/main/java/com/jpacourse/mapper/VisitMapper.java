package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.impl.DoctorDaoImpl;
import com.jpacourse.persistence.dao.impl.PatientDaoImpl;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.DoctorService;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public final class VisitMapper {

    @Autowired
    public PatientDao patientDao;

    @Autowired
    public DoctorDao doctorDao;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    public VisitMapper() {}

    public VisitTO mapToTO(VisitEntity visitEntity) {
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

    public VisitEntity mapToEntity(VisitTO visitTO) {
        if (visitTO == null) return null;
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        //visitEntity.setPatient(PatientMapper.mapToEntity(patientService.findById(visitTO.getPatientId())));
        //visitEntity.setDoctor(DoctorMapper.mapToEntity(doctorService.findById(visitTO.getDoctorId())));
        return visitEntity;
    }
}
