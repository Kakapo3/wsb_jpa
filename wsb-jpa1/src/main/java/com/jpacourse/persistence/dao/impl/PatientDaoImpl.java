package com.jpacourse.persistence.dao.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PatientTO> getPatientByLastName(String lastName) {
        String jpql = "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        query.setParameter("lastName", lastName);

        return query.getResultList().stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public List<VisitTO> getVisitByPatientId(Long patientId) {
        String jpql = "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId";
        TypedQuery<VisitEntity> query = entityManager.createQuery(jpql, VisitEntity.class);
        query.setParameter("patientId", patientId);

        VisitMapper vm = new VisitMapper();
        return query.getResultList().stream().map(vm::mapToTO).collect(Collectors.toList());
    }

    @Override
    public List<PatientTO> getPatientsByNumOfVisitsGreaterThan(Long numOfVisits) {
        String jpql = "SELECT p FROM PatientEntity p LEFT JOIN  p.visits v GROUP BY p HAVING count(v) >= :numOfVisits";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        query.setParameter("numOfVisits", numOfVisits);

        return query.getResultList().stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public List<PatientTO> getPatientsByAnnualIncomeLesserThan(Long value) {
        String jpql = "SELECT p FROM PatientEntity p WHERE p.annualIncome < :value";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        query.setParameter("value", value);
        return query.getResultList().stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }

}
