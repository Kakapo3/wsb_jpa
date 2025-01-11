package com.jpacourse.persistance.dao;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    VisitDao visitDao;

    @Transactional
    @Test
    public void testCreateVisit() {
        // given
        LocalDateTime now = LocalDateTime.now();
        int initialSize = visitDao.findAll().size();
        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        DoctorEntity doctorEntity = doctorDao.findOne(1L);
        patientDao.createVisit(patientEntity.getId(), doctorEntity.getId(), now.plusYears(1), "Some description");
        // then
        assertThat(visitDao.findAll().size()).isEqualTo(initialSize + 1);
    }

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {
        // given
        // when
        List<PatientTO> patientTOlist = patientDao.getPatientByLastName("Nowak");
        // then
        assertThat(patientTOlist).isNotNull();
        assertThat(patientTOlist.size()).isEqualTo(1);
    }

}
