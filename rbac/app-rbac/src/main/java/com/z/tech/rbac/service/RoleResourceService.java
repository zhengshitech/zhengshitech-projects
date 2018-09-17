package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.RoleResourceDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface RoleResourceService {
    /**
     * 保存角色资源授权
     *
     * @param roleResource 新的角色资源授权数据
     */
    void save(@Valid RoleResourceDTO roleResource);

    /**
     * 批量保存
     *
     * @param roleResources 数据
     * @return 保存的数量行数
     */
    int save(@Valid List<RoleResourceDTO> roleResources);

    /**
     * 修改角色资源授权
     *
     * @param roleResource 旧的角色资源授权数据
     */
    void modify(@Valid RoleResourceDTO roleResource);

    /**
     * 删除角色资源授权数据
     *
     * @param id 角色资源授权ID
     */
    void delete(Integer id);

    /**
     * 删除资源的角色授权
     *
     * @param resourceId 资源id
     * @return 删除的数据行数
     */
    int deleteByResource(Integer resourceId);

    /**
     * 删除角色的所有角色资源授权数据
     *
     * @param roleId 角色ID
     * @return 删除的数据行数
     */
    int deleteByRole(Integer roleId);

    /**
     * 根据ID查询角色资源授权数据
     *
     * @param id 角色资源授权ID
     * @return 角色资源授权数据
     */
    RoleResourceDTO getByID(Integer id);

    /**
     * 查询资源的角色授权数据
     *
     * @param resourceId 资源ID
     * @return 角色资源授权数据
     */
    List<RoleResourceDTO> getByResource(Integer resourceId);

    /**
     * 查询角色授权的资源数据
     *
     * @param roleId 角色ID
     * @return 角色资源授权数据
     */
    List<RoleResourceDTO> getByRole(Integer roleId);

    /**
     * 根据ID集合查询角色资源授权数据
     *
     * @param ids 角色资源授权ID集合
     * @return 查询到的角色资源授权数据
     */
    List<RoleResourceDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个角色资源授权ID") List<Integer> ids);


}
