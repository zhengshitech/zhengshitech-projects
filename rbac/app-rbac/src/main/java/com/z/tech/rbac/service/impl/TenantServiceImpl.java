package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.TenantDao;
import com.z.tech.rbac.dto.TenantDTO;
import com.z.tech.rbac.service.TenantService;
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
public class TenantServiceImpl implements TenantService {


    private final TenantDao tenantDao;

    @Autowired
    public TenantServiceImpl(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }

    @Override
    public void save(@Valid TenantDTO newTenant) {
        Integer pid = newTenant.getPid();
        TenantDTO parent = getByID(pid);
        int targetLevel = 0;
        if (null == parent) {
            //root
        } else {
            targetLevel = parent.getLevel() + 1;
        }
        String myMask = getNextMask(getMaxMaskNum(targetLevel), 3);
        newTenant.setMask(getMask(parent, myMask));
        newTenant.setLevel(targetLevel);
        tenantDao.save(newTenant);
    }



    @Override
    public void modify(@Valid TenantDTO oldTenant) {
        tenantDao.modify(oldTenant);
    }

    @Override
    public void delete(Integer id) {
        tenantDao.delete(id);
    }

    @Override
    public TenantDTO getByID(Integer id) {
        return tenantDao.getByID(id);
    }

    @Override
    public List<TenantDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个租户ID") List<Integer> ids) {
        return tenantDao.getByIDs(ids);
    }

    private int getMaxMaskNum(int level) {
        return tenantDao.getMaxMaskNum(level);
    }

    private String getNextMask(int currentSort, int maskLength) {
        int nextSort = currentSort + 1;
        String maskSequence = "" + nextSort;
        int currentLength = maskSequence.length();
        StringBuilder sb = new StringBuilder();
        if (currentLength < maskLength) {
            int completionLength = maskLength - currentLength;
            for (int i = 0; i < completionLength; i++) {
                sb.append("0");
            }
        }
        return sb.append(maskSequence).toString();
    }

    private String getMask(TenantDTO parent, String myMask) {
        if (null == parent) {
            return myMask;
        } else {
            return parent.getMask() + "_" + myMask;
        }
    }
}
