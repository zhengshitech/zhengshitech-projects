package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.ApplicationDao;
import com.z.tech.rbac.dto.ApplicationDTO;
import com.z.tech.rbac.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

import static com.z.tech.rbac.util.CipherUtil.doEncrypt;
import static com.z.tech.rbac.util.UUIDUtil.randomUUID;

/**
 * @author H
 */
@Service
@Validated
public class ApplicationServiceImpl implements ApplicationService {


    private final ApplicationDao applicationDao;

    @Autowired
    public ApplicationServiceImpl(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    @Override
    public void save(@Valid ApplicationDTO application) {
        String key = randomUUID();
        application.setAppKey(key.toUpperCase());
        applicationDao.save(application);
    }


    @Override
    public void modify(@Valid ApplicationDTO application) {
        applicationDao.modify(application);
    }

    @Override
    public void delete(Integer id) {
        applicationDao.delete(id);
    }

    @Override
    public ApplicationDTO getByID(Integer id) {
        return applicationDao.getByID(id);
    }

    @Override
    public List<ApplicationDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个应用ID") List<Integer> ids) {
        return applicationDao.getByIDs(ids);
    }

    @Override
    public boolean getByAppKey(String key, Integer excludeId) {
        return applicationDao.getByAppKey(key,excludeId);
    }
}
