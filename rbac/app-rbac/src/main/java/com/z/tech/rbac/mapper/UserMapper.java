package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface UserMapper {


    /**
     * 插入数据
     *
     * @param user 数据
     */
    void insert(UserDTO user);

    /**
     * 更新数据
     *
     * @param user 数据
     */
    void update(UserDTO user);

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
     * @return 租户
     */
    UserDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<UserDTO> selectByIDs(List<Integer> ids);

    /**
     * 查询此电话号码的使用数据
     *
     * @param phone 电话号码
     * @return 数量
     */
    int selectByPhone(String phone);

    /**
     * 根据部门查询用户
     * @param departmentId 部门ID
     * @return 用户数据
     */
    List<UserDTO> selectByDepartment(Integer departmentId);
}
