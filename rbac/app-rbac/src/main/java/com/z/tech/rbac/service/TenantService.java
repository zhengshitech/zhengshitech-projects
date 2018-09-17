package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.TenantDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface TenantService {
    /**
     * 保存租户
     *
     * @param newTenant 新的租户数据
     */
    void save(@Valid TenantDTO newTenant);

    /**
     * 修改租户
     *
     * @param oldTenant 旧的租户数据
     */
    void modify(@Valid TenantDTO oldTenant);

    /**
     * 删除租户数据
     *
     * @param id 租户ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询租户数据
     *
     * @param id 租户ID
     * @return 租户数据
     */
    TenantDTO getByID(Integer id);

    /**
     * 根据ID集合查询租户数据
     *
     * @param ids 租户ID集合
     * @return 查询到的租户数据
     */
    List<TenantDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个租户ID") List<Integer> ids);
}
