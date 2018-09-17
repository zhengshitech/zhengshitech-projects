package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.RoleDao;
import com.z.tech.rbac.dto.RoleDTO;
import com.z.tech.rbac.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public void save(RoleDTO role) {
        roleMapper.insert(role);
    }

    @Override
    public void modify(RoleDTO role) {

        roleMapper.update(role);
    }

    @Override
    public void delete(Integer id) {
        roleMapper.delete(id);
    }

    @Override
    public RoleDTO getByID(Integer id) {
        return roleMapper.selectByID(id);
    }

    @Override
    public List<RoleDTO> getByIDs(List<Integer> ids) {
        return roleMapper.selectByIDs(ids);
    }

    @Override
    public boolean getByCodeAndApplication(String code, Integer excludeId, Integer applicationId) {
        return roleMapper.selectByCodeAndApplication(code,excludeId,applicationId)>0;
    }
}
