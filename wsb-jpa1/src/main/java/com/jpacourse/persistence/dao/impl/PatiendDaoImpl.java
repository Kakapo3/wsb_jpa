package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PatiendDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
}
