package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.TenantDao;
import com.z.tech.rbac.dto.TenantDTO;
import com.z.tech.rbac.mapper.TenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class TenantDaoImpl implements TenantDao {

    @Autowired
    private TenantMapper tenantMapper;


    @Override
    public void save(TenantDTO newTenant) {
        tenantMapper.insert(newTenant);
    }

    @Override
    public void modify(TenantDTO oldTenant) {

        tenantMapper.update(oldTenant);
    }

    @Override
    public void delete(Integer id) {
        tenantMapper.delete(id);
    }

    @Override
    public TenantDTO getByID(Integer id) {
        return tenantMapper.selectByID(id);
    }

    @Override
    public List<TenantDTO> getByIDs(List<Integer> ids) {
        return tenantMapper.selectByIDs(ids);
    }

    @Override
    public int getMaxMaskNum(int level) {
        Integer maxMaskNum = tenantMapper.selectMaxMaskNum(level);
        return maxMaskNum == null ? 0 : maxMaskNum;
    }
}
