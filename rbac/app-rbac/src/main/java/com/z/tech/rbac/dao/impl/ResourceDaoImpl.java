package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.ResourceDao;
import com.z.tech.rbac.dto.ResourceDTO;
import com.z.tech.rbac.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class ResourceDaoImpl implements ResourceDao {

    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    public void save(ResourceDTO resource) {
        resourceMapper.insert(resource);
    }

    @Override
    public void modify(ResourceDTO resource) {

        resourceMapper.update(resource);
    }

    @Override
    public void delete(Integer id) {
        resourceMapper.delete(id);
    }

    @Override
    public ResourceDTO getByID(Integer id) {
        return resourceMapper.selectByID(id);
    }

    @Override
    public List<ResourceDTO> getByIDs(List<Integer> ids) {
        return resourceMapper.selectByIDs(ids);
    }

    @Override
    public boolean getByResourceKeyAndApplication(String resourceKey, Integer excludeId, Integer applicationId, Integer type) {
        return resourceMapper.selectByResourceKeyAndApplication(resourceKey,excludeId,applicationId,type)>0;
    }

    @Override
    public List<ResourceDTO> getByApplication(Integer applicationId, Integer type) {
        return resourceMapper.selectByApplication(applicationId,type);
    }
}
