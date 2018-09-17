package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.ApplicationDTO;

import java.util.List;

/**
 * @author H
 */
public interface ApplicationDao {
    /**
     * 保存
     *
     * @param application 数据
     */
    void save(ApplicationDTO application);

    /**
     * 修改
     *
     * @param application 数据
     */
    void modify(ApplicationDTO application);

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
    ApplicationDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<ApplicationDTO> getByIDs(List<Integer> ids);

    /**
     *
     * 查询是否有key存在
     * @param key 检测的key
     * @param excludeId 排除的ID
     * @return 是否存在
     */
    boolean getByAppKey(String key, Integer excludeId);
}
