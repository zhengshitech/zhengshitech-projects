package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.RoleResourceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface RoleResourceMapper {


    /**
     * 插入数据
     *
     * @param roleResource 数据
     */
    void insert(RoleResourceDTO roleResource);

    /**
     * 批量保存
     *
     * @param roleResources 授权数据
     * @return 插入行
     */
    int insertBatch(List<RoleResourceDTO> roleResources);


    /**
     * 更新数据
     *
     * @param roleResource 数据
     */
    void update(RoleResourceDTO roleResource);

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
    RoleResourceDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<RoleResourceDTO> selectByIDs(List<Integer> ids);


    /**
     * 根据资源查询授权
     *
     * @param resourceId 资源ID
     * @return 授权数据
     */
    List<RoleResourceDTO> selectByResource(Integer resourceId);

    /**
     * 根据角色查询授权
     *
     * @param roleId 角色ＩＤ
     * @return 授权数据
     */
    List<RoleResourceDTO> selectByRole(Integer roleId);

    /**
     * 批量删除
     *
     * @param resourceId 资源ID
     * @return 删除行
     */
    int deleteByResource(Integer resourceId);

    /**
     * 批量删除
     *
     * @param roleId 角色ID
     * @return 删除行
     */
    int deleteByRole(Integer roleId);

}
