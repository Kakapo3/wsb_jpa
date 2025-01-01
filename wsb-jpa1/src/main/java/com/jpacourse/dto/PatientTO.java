package com.jpacourse.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PatientTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private AddressTO address;
    private List<VisitTO> visits = new ArrayList<>();
    private Long annualIncome;
}
