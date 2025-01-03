package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

public interface VisitService {
    VisitTO findById(Long id);
    void deleteById(Long id);
    void deleteAll();
}
