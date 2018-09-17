package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.RoleResourceDTO;

import java.util.List;

/**
 * @author H
 */
public interface RoleResourceDao {
    /**
     * 保存
     *
     * @param roleResource 数据
     */
    void save(RoleResourceDTO roleResource);

    /**
     * 批量保存
     *
     * @param roleResources 授权数据
     * @return 保存数量
     */
    int save(List<RoleResourceDTO> roleResources);

    /**
     * 修改
     *
     * @param roleResource 数据
     */
    void modify(RoleResourceDTO roleResource);

    /**
     * 根据ID删除
     *
     * @param id ID
     */
    void delete(Integer id);

    /**
     * 根据资源删除授权数据
     *
     * @param resourceId 资源
     * @return 删除的数量
     */
    int deleteByResource(Integer resourceId);

    /**
     * 根据角色删除授权数据
     *
     * @param roleId 角色
     * @return 删除的数量
     */
    int deleteByRole(Integer roleId);

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return 数据
     */
    RoleResourceDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<RoleResourceDTO> getByIDs(List<Integer> ids);


    /**
     * 根据资源查询授权数据
     *
     * @param resourceId 资源
     * @return 授权数据
     */
    List<RoleResourceDTO> getByResource(Integer resourceId);

    /**
     * 根据角色查询授权数据
     *
     * @param roleId 角色
     * @return 授权数据
     */
    List<RoleResourceDTO> getByRole(Integer roleId);
}
