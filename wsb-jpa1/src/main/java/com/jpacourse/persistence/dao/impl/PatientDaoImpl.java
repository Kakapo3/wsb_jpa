package com.jpacourse.persistence.dao.impl;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Override
    public VisitTO createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription) {
        VisitTO visitTO = new VisitTO();

        PatientEntity patientEntity = findOne(patientId);
        if (patientEntity == null) {
            throw new IllegalArgumentException("Patient with id " + patientId + " does not exist");
        }

        DoctorEntity doctorEntity = doctorDao.findOne(doctorId);
        if (doctorEntity == null) {
            throw new IllegalArgumentException("Doctor with id " + doctorId + " does not exist");
        }

        visitTO.setTime(visitDate);
        visitTO.setDescription(visitDescription);


        VisitMapper vm = new VisitMapper();
        VisitEntity ve = vm.mapToEntity(visitTO);
        ve.setPatient(patientEntity);
        ve.setDoctor(doctorEntity);
        System.out.println(ve);
        System.out.println(ve.getPatient().getFirstName() + " " + ve.getPatient().getLastName());
        System.out.println(ve.getDoctor().getFirstName());
        visitDao.save(ve);

        return visitTO;
    }
}
