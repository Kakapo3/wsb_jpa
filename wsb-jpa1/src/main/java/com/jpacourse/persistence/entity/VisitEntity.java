package com.jpacourse.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    // relcja dwustronna
    @ManyToOne
    @JoinColumn(name = "doctor", nullable = false) // musi być przypisany lekarz
    @JsonBackReference // zapobieganie zapętleniu się podczas serializacji do JSONa
    private DoctorEntity doctor;

    // relacja dwustronna
    @ManyToOne
    @JoinColumn(name = "patient", nullable = false) // musi być przypisany pacjent
    @JsonBackReference // zapobieganie zapętleniu się podczas serializacji do JSONa
    private PatientEntity patient;

    @Nullable // wizyta nie musi mieć przypisanych zabiegów, gdy sie np okaże że pacjent jest zdrowy
    @OneToMany
    @JoinColumn(name = "medical_treatments")
    private List<MedicalTreatmentEntity> medicalTreatments;

    @Nullable
    public List<MedicalTreatmentEntity> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(@Nullable List<MedicalTreatmentEntity> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
