package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.RoleDTO;

import java.util.List;

/**
 * @author H
 */
public interface RoleDao {
    /**
     * 保存
     *
     * @param role 数据
     */
    void save(RoleDTO role);

    /**
     * 修改
     *
     * @param role 数据
     */
    void modify(RoleDTO role);

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
    RoleDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<RoleDTO> getByIDs(List<Integer> ids);

    /**
     * 查询代码是否存在
     *
     * @param code          代码
     * @param excludeId     排除ID
     * @param applicationId 应用ID
     * @return 是否存在
     */
    boolean getByCodeAndApplication(String code, Integer excludeId, Integer applicationId);
}
