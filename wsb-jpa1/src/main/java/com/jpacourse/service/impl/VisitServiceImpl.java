package com.jpacourse.service.impl;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitDao VisitDao;

    @Autowired
    public VisitServiceImpl(VisitDao VisitDao) {
        this.VisitDao = VisitDao;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = VisitDao.findOne(id);
        VisitMapper visitMapper = new VisitMapper();
        return visitMapper.mapToTO(entity);
    }

    @Override
    public void deleteById(Long id) {
        VisitDao.delete(id);
    }

    @Override
    public void deleteAll() {
        VisitDao.deleteAll();
    }


}
