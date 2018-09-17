package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.ResourceDao;
import com.z.tech.rbac.dto.ResourceDTO;
import com.z.tech.rbac.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
@Service
@Validated
public class ResourceServiceImpl implements ResourceService {


    private final ResourceDao resourceDao;

    @Autowired
    public ResourceServiceImpl(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }

    @Override
    public void save(@Valid ResourceDTO resource) {
        resourceDao.save(resource);
    }


    @Override
    public void modify(@Valid ResourceDTO resource) {
        resourceDao.modify(resource);
    }

    @Override
    public void delete(Integer id) {
        resourceDao.delete(id);
    }

    @Override
    public ResourceDTO getByID(Integer id) {
        return resourceDao.getByID(id);
    }

    @Override
    public List<ResourceDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个资源ID") List<Integer> ids) {
        return resourceDao.getByIDs(ids);
    }

    @Override
    public boolean getByResourceKeyAndApplication(String resourceKey, Integer excludeId, Integer applicationId, Integer type) {
        return resourceDao.getByResourceKeyAndApplication(resourceKey,excludeId,applicationId,type);
    }

    @Override
    public List<ResourceDTO> getByApplication(Integer applicationId, Integer type) {
        return resourceDao.getByApplication(applicationId,type);
    }
}
