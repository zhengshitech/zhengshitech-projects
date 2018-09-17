package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.ApplicationDao;
import com.z.tech.rbac.dto.ApplicationDTO;
import com.z.tech.rbac.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    @Autowired
    private ApplicationMapper applicationMapper;


    @Override
    public void save(ApplicationDTO application) {
        applicationMapper.insert(application);
    }

    @Override
    public void modify(ApplicationDTO application) {

        applicationMapper.update(application);
    }

    @Override
    public void delete(Integer id) {
        applicationMapper.delete(id);
    }

    @Override
    public ApplicationDTO getByID(Integer id) {
        return applicationMapper.selectByID(id);
    }

    @Override
    public List<ApplicationDTO> getByIDs(List<Integer> ids) {
        return applicationMapper.selectByIDs(ids);
    }

    @Override
    public boolean getByAppKey(String key, Integer excludeId) {
        return applicationMapper.selectByAppKey(key,excludeId)>0;
    }
}
