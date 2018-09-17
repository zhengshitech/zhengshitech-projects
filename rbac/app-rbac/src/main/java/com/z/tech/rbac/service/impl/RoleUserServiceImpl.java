package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.RoleUserDao;
import com.z.tech.rbac.dto.RoleUserDTO;
import com.z.tech.rbac.service.RoleUserService;
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
public class RoleUserServiceImpl implements RoleUserService {


    private final RoleUserDao roleUserDao;

    @Autowired
    public RoleUserServiceImpl(RoleUserDao roleUserDao) {
        this.roleUserDao = roleUserDao;
    }

    @Override
    public void save(@Valid RoleUserDTO roleUser) {
        roleUserDao.save(roleUser);
    }

    @Override
    public int save(@Valid List<RoleUserDTO> roleUsers) {
        return roleUserDao.save(roleUsers);
    }


    @Override
    public void modify(@Valid RoleUserDTO roleUser) {
        roleUserDao.modify(roleUser);
    }

    @Override
    public void delete(Integer id) {
        roleUserDao.delete(id);
    }

    @Override
    public int deleteByUser(Integer userId) {
        return roleUserDao.deleteByUser(userId);
    }

    @Override
    public int deleteByRole(Integer roleId) {
        return roleUserDao.deleteByRole(roleId);
    }

    @Override
    public RoleUserDTO getByID(Integer id) {
        return roleUserDao.getByID(id);
    }

    @Override
    public List<RoleUserDTO> getByUser(Integer userId) {
        return roleUserDao.getByUser(userId);
    }

    @Override
    public List<RoleUserDTO> getByRole(Integer roleId) {
        return roleUserDao.getByRole(roleId);
    }

    @Override
    public List<RoleUserDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个角色用户授权ID") List<Integer> ids) {
        return roleUserDao.getByIDs(ids);
    }

}
