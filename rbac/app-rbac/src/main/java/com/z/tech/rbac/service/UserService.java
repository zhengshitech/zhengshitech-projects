package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.UserDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface UserService {
    /**
     * 保存用户
     *
     * @param user 新的用户数据
     */
    void save(@Valid UserDTO user);

    /**
     * 修改用户
     *
     * @param user 旧的用户数据
     */
    void modify(@Valid UserDTO user);

    /**
     * 删除用户数据
     *
     * @param id 用户ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询用户数据
     *
     * @param id 用户ID
     * @return 用户数据
     */
    UserDTO getByID(Integer id);

    /**
     * 根据ID集合查询用户数据
     *
     * @param ids 用户ID集合
     * @return 查询到的用户数据
     */
    List<UserDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个用户ID") List<Integer> ids);

    /**
     * 根据电话查询
     * @param phone 电话号码
     * @return 是否存在
     */
    boolean getByPhone(String phone);

    /**
     * 根据部门查询用户
     * @param departmentId 部门
     * @return 用户
     */
    List<UserDTO> getByDepartment(Integer departmentId);
}
