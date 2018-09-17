package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.RoleResourceDao;
import com.z.tech.rbac.dto.RoleResourceDTO;
import com.z.tech.rbac.mapper.RoleResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class RoleResourceDaoImpl implements RoleResourceDao {

    @Autowired
    private RoleResourceMapper roleResourceMapper;


    @Override
    public void save(RoleResourceDTO roleResource) {
        roleResourceMapper.insert(roleResource);
    }

    @Override
    public void modify(RoleResourceDTO roleResource) {

        roleResourceMapper.update(roleResource);
    }

    @Override
    public void delete(Integer id) {
        roleResourceMapper.delete(id);
    }

    @Override
    public RoleResourceDTO getByID(Integer id) {
        return roleResourceMapper.selectByID(id);
    }

    @Override
    public List<RoleResourceDTO> getByIDs(List<Integer> ids) {
        return roleResourceMapper.selectByIDs(ids);
    }

    @Override
    public int save(List<RoleResourceDTO> roleResources) {
        return roleResourceMapper.insertBatch(roleResources);
    }

    @Override
    public int deleteByResource(Integer resourceId) {
        return roleResourceMapper.deleteByResource(resourceId);
    }

    @Override
    public int deleteByRole(Integer roleId) {
        return roleResourceMapper.deleteByRole(roleId);
    }

    @Override
    public List<RoleResourceDTO> getByResource(Integer resourceId) {
        return roleResourceMapper.selectByResource(resourceId);
    }

    @Override
    public List<RoleResourceDTO> getByRole(Integer roleId) {
        return roleResourceMapper.selectByRole(roleId);
    }

}
