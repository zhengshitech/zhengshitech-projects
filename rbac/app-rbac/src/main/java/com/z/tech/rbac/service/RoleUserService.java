package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.RoleUserDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface RoleUserService {
    /**
     * 保存角色用户授权
     *
     * @param roleUser 新的角色用户授权数据
     */
    void save(@Valid RoleUserDTO roleUser);

    /**
     * 批量保存
     *
     * @param roleUsers 数据
     * @return 保存的数量行数
     */
    int save(@Valid List<RoleUserDTO> roleUsers);

    /**
     * 修改角色用户授权
     *
     * @param roleUser 旧的角色用户授权数据
     */
    void modify(@Valid RoleUserDTO roleUser);

    /**
     * 删除角色用户授权数据
     *
     * @param id 角色用户授权ID
     */
    void delete(Integer id);

    /**
     * 删除用户的角色授权
     *
     * @param userId 用户id
     * @return 删除的数据行数
     */
    int deleteByUser(Integer userId);

    /**
     * 删除角色的所有角色用户授权数据
     *
     * @param roleId 角色ID
     * @return 删除的数据行数
     */
    int deleteByRole(Integer roleId);

    /**
     * 根据ID查询角色用户授权数据
     *
     * @param id 角色用户授权ID
     * @return 角色用户授权数据
     */
    RoleUserDTO getByID(Integer id);

    /**
     * 查询用户的角色授权数据
     *
     * @param userId 用户ID
     * @return 角色用户授权数据
     */
    List<RoleUserDTO> getByUser(Integer userId);

    /**
     * 查询角色授权的用户数据
     *
     * @param roleId 角色ID
     * @return 角色用户授权数据
     */
    List<RoleUserDTO> getByRole(Integer roleId);

    /**
     * 根据ID集合查询角色用户授权数据
     *
     * @param ids 角色用户授权ID集合
     * @return 查询到的角色用户授权数据
     */
    List<RoleUserDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个角色用户授权ID") List<Integer> ids);


}
