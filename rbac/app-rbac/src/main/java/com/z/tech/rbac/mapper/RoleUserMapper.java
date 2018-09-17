package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.RoleUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface RoleUserMapper {


    /**
     * 插入数据
     *
     * @param roleUser 数据
     */
    void insert(RoleUserDTO roleUser);

    /**
     * 批量保存
     *
     * @param roleUsers 授权数据
     * @return 插入行
     */
    int insertBatch(List<RoleUserDTO> roleUsers);


    /**
     * 更新数据
     *
     * @param roleUser 数据
     */
    void update(RoleUserDTO roleUser);

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
    RoleUserDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<RoleUserDTO> selectByIDs(List<Integer> ids);


    /**
     * 根据用户查询授权
     *
     * @param userId 用户ID
     * @return 授权数据
     */
    List<RoleUserDTO> selectByUser(Integer userId);

    /**
     * 根据角色查询授权
     *
     * @param roleId 角色ＩＤ
     * @return 授权数据
     */
    List<RoleUserDTO> selectByRole(Integer roleId);

    /**
     * 批量删除
     *
     * @param userId 用户ID
     * @return 删除行
     */
    int deleteByUser(Integer userId);

    /**
     * 批量删除
     *
     * @param roleId 角色ID
     * @return 删除行
     */
    int deleteByRole(Integer roleId);

}
