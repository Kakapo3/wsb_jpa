package com.jpacourse.persistence.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    VisitTO createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription);

    List<PatientTO> getPatientByLastName(String lastName);

    List<VisitTO> getVisitByPatientId(Long patientId);

    List<PatientTO> getPatientsByNumOfVisitsGreaterThan(Long numOfVisits);

    List<PatientTO> getPatientsByAnnualIncomeLesserThan(Long value);

}
