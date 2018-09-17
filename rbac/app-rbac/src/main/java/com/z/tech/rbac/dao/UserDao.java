package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.UserDTO;

import java.util.List;

/**
 * @author H
 */
public interface UserDao {
    /**
     * 保存
     *
     * @param user 数据
     */
    void save(UserDTO user);

    /**
     * 修改
     *
     * @param user 数据
     */
    void modify(UserDTO user);

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
    UserDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<UserDTO> getByIDs(List<Integer> ids);

    /**
     * 查询电话是否存在
     * @param phone 电话
     * @return 是否存在
     */
    boolean getByPhone(String phone);

    /**
     * 根据部门查询用户
     * @param departmentId 部门ID
     * @return 用户
     */
    List<UserDTO> getByDepartment(Integer departmentId);
}
