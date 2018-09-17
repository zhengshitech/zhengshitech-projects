package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.RoleDao;
import com.z.tech.rbac.dto.RoleDTO;
import com.z.tech.rbac.service.RoleService;
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
public class RoleServiceImpl implements RoleService {


    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void save(@Valid RoleDTO role) {
        roleDao.save(role);
    }


    @Override
    public void modify(@Valid RoleDTO role) {
        roleDao.modify(role);
    }

    @Override
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public RoleDTO getByID(Integer id) {
        return roleDao.getByID(id);
    }

    @Override
    public List<RoleDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个角色ID") List<Integer> ids) {
        return roleDao.getByIDs(ids);
    }

    @Override
    public boolean getByCodeAndApplication(String code, Integer excludeId, Integer applicationId) {
        return roleDao.getByCodeAndApplication(code,excludeId,applicationId);
    }
}
