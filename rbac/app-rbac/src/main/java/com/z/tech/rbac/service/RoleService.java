package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.RoleDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface RoleService {
    /**
     * 保存角色
     *
     * @param role 新的角色数据
     */
    void save(@Valid RoleDTO role);

    /**
     * 修改角色
     *
     * @param role 旧的角色数据
     */
    void modify(@Valid RoleDTO role);

    /**
     * 删除角色数据
     *
     * @param id 角色ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询角色数据
     *
     * @param id 角色ID
     * @return 角色数据
     */
    RoleDTO getByID(Integer id);

    /**
     * 根据ID集合查询角色数据
     *
     * @param ids 角色ID集合
     * @return 查询到的角色数据
     */
    List<RoleDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个角色ID") List<Integer> ids);


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
