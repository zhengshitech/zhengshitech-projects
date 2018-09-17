package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.RoleResourceDao;
import com.z.tech.rbac.dto.RoleResourceDTO;
import com.z.tech.rbac.service.RoleResourceService;
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
public class RoleResourceServiceImpl implements RoleResourceService {


    private final RoleResourceDao roleResourceDao;

    @Autowired
    public RoleResourceServiceImpl(RoleResourceDao roleResourceDao) {
        this.roleResourceDao = roleResourceDao;
    }

    @Override
    public void save(@Valid RoleResourceDTO roleResource) {
        roleResourceDao.save(roleResource);
    }

    @Override
    public int save(@Valid List<RoleResourceDTO> roleResources) {
        return roleResourceDao.save(roleResources);
    }


    @Override
    public void modify(@Valid RoleResourceDTO roleResource) {
        roleResourceDao.modify(roleResource);
    }

    @Override
    public void delete(Integer id) {
        roleResourceDao.delete(id);
    }

    @Override
    public int deleteByResource(Integer resourceId) {
        return roleResourceDao.deleteByResource(resourceId);
    }

    @Override
    public int deleteByRole(Integer roleId) {
        return roleResourceDao.deleteByRole(roleId);
    }

    @Override
    public RoleResourceDTO getByID(Integer id) {
        return roleResourceDao.getByID(id);
    }

    @Override
    public List<RoleResourceDTO> getByResource(Integer resourceId) {
        return roleResourceDao.getByResource(resourceId);
    }

    @Override
    public List<RoleResourceDTO> getByRole(Integer roleId) {
        return roleResourceDao.getByRole(roleId);
    }

    @Override
    public List<RoleResourceDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个角色资源授权ID") List<Integer> ids) {
        return roleResourceDao.getByIDs(ids);
    }

}
