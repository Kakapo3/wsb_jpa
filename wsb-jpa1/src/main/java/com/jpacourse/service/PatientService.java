package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientService {
    PatientTO findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    List<PatientTO> findByLastName(String lastName);
    List<VisitTO> findVisitByPatientId(Long patientId);
}
