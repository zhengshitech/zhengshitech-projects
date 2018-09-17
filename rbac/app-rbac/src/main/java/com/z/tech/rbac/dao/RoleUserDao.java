package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.RoleUserDTO;

import java.util.List;

/**
 * @author H
 */
public interface RoleUserDao {
    /**
     * 保存
     *
     * @param roleUser 数据
     */
    void save(RoleUserDTO roleUser);

    /**
     * 修改
     *
     * @param roleUser 数据
     */
    void modify(RoleUserDTO roleUser);

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
    RoleUserDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<RoleUserDTO> getByIDs(List<Integer> ids);

    /**
     * 批量保存
     *
     * @param roleUsers 授权数据
     * @return 保存数量
     */
    int save(List<RoleUserDTO> roleUsers);

    /**
     * 根据用户删除授权数据
     *
     * @param userId 用户
     * @return 删除的数量
     */
    int deleteByUser(Integer userId);

    /**
     * 根据角色删除授权数据
     *
     * @param roleId 角色
     * @return 删除的数量
     */
    int deleteByRole(Integer roleId);

    /**
     * 根据用户查询授权数据
     *
     * @param userId 用户
     * @return 授权数据
     */
    List<RoleUserDTO> getByUser(Integer userId);

    /**
     * 根据角色查询授权数据
     *
     * @param roleId 角色
     * @return 授权数据
     */
    List<RoleUserDTO> getByRole(Integer roleId);
}
