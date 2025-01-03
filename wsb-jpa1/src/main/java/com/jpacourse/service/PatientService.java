package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

public interface PatientService {
    PatientTO findById(Long id);
    void deleteById(Long id);
    void deleteAll();
}
