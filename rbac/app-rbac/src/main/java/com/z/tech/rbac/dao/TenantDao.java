package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.TenantDTO;

import java.util.List;

/**
 * @author H
 */
public interface TenantDao {
    /**
     * 保存
     *
     * @param newTenant 数据
     */
    void save(TenantDTO newTenant);

    /**
     * 修改
     *
     * @param oldTenant 数据
     */
    void modify(TenantDTO oldTenant);

    /**
     * 根据ID删除
     *
     * @param id ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return 数据
     */
    TenantDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<TenantDTO> getByIDs(List<Integer> ids);

    /**
     * 获取最大的层次掩码序号
     * @param level 层级
     * @return 最大序号
     */
    int getMaxMaskNum(int level);
}
