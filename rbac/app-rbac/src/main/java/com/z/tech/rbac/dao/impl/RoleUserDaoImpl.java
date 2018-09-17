package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.RoleUserDao;
import com.z.tech.rbac.dto.RoleUserDTO;
import com.z.tech.rbac.mapper.RoleUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class RoleUserDaoImpl implements RoleUserDao {

    @Autowired
    private RoleUserMapper roleUserMapper;


    @Override
    public void save(RoleUserDTO roleUser) {
        roleUserMapper.insert(roleUser);
    }

    @Override
    public void modify(RoleUserDTO roleUser) {

        roleUserMapper.update(roleUser);
    }

    @Override
    public void delete(Integer id) {
        roleUserMapper.delete(id);
    }

    @Override
    public RoleUserDTO getByID(Integer id) {
        return roleUserMapper.selectByID(id);
    }

    @Override
    public List<RoleUserDTO> getByIDs(List<Integer> ids) {
        return roleUserMapper.selectByIDs(ids);
    }

    @Override
    public int save(List<RoleUserDTO> roleUsers) {
        return roleUserMapper.insertBatch(roleUsers);
    }

    @Override
    public int deleteByUser(Integer userId) {
        return roleUserMapper.deleteByUser(userId);
    }

    @Override
    public int deleteByRole(Integer roleId) {
        return roleUserMapper.deleteByRole(roleId);
    }

    @Override
    public List<RoleUserDTO> getByUser(Integer userId) {
        return roleUserMapper.selectByUser(userId);
    }

    @Override
    public List<RoleUserDTO> getByRole(Integer roleId) {
        return roleUserMapper.selectByRole(roleId);
    }

}
