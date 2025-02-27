package com.jpacourse.persistance.dao;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.DoctorService;
import com.jpacourse.service.PatientService;
import com.jpacourse.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testDeletingPatientShouldDeleteVisitNotDoctor() {
        // given
        PatientTO patientTO = patientService.findById(2L);
        assertThat(patientTO).isNotNull();
        VisitTO visitTO = visitService.findById(3L);
        assertThat(visitTO).isNotNull();
        DoctorTO doctorTO = doctorService.findById(1L);
        assertThat(doctorTO).isNotNull();
        // when

        patientService.deleteById(patientTO.getId());
        // then
        PatientTO newPatientTO = patientService.findById(patientTO.getId());
        assertThat(newPatientTO).isNull();
        visitTO = visitService.findById(3L);
        assertThat(visitTO).isNull();
        doctorTO = doctorService.findById(1L);
        assertThat(doctorTO).isNotNull();
    }

    @Transactional
    @Test
    public void testShouldFindEmailById() {
        // given
        // when
        PatientTO patientTO = patientService.findById(1L);
        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getEmail()).isEqualTo("bartosz.nowak@gmail.com");
    }

    @Transactional
    @Test
    public void testShouldFindVisitById() {
        // given
        // when
        PatientTO patientTO = patientService.findById(1L);
        // then
        List<VisitTO> visits = patientService.findVisitByPatientId(patientTO.getId());
        assertThat(visits).isNotNull();
        assertThat(visits).size().isEqualTo(2);
    }
}
