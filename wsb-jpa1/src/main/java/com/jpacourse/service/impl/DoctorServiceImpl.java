package com.jpacourse.service.impl;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.mapper.DoctorMapper;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao DoctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao DoctorDao) {
        this.DoctorDao = DoctorDao;
    }

    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity entity = DoctorDao.findOne(id);
        return DoctorMapper.mapToTO(entity);
    }

    @Override
    public void deleteById(Long id) {
        DoctorDao.delete(id);
    }

    @Override
    public void deleteAll() {
        DoctorDao.deleteAll();
    }


}
