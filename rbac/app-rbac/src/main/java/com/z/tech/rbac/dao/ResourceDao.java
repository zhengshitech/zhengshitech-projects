package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.ResourceDTO;

import java.util.List;

/**
 * @author H
 */
public interface ResourceDao {
    /**
     * 保存
     *
     * @param resource 数据
     */
    void save(ResourceDTO resource);

    /**
     * 修改
     *
     * @param resource 数据
     */
    void modify(ResourceDTO resource);

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
    ResourceDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<ResourceDTO> getByIDs(List<Integer> ids);

    /**
     * 查询代码是否存在
     *
     * @param resourceKey   代码
     * @param excludeId     排除ID
     * @param applicationId 应用ID
     * @param type          类型
     * @return 是否存在
     */
    boolean getByResourceKeyAndApplication(String resourceKey, Integer excludeId, Integer applicationId, Integer type);

    /**
     * 查询一个应用的资源
     *
     * @param applicationId 应用
     * @param type          类型
     * @return 资源
     */
    List<ResourceDTO> getByApplication(Integer applicationId, Integer type);
}
