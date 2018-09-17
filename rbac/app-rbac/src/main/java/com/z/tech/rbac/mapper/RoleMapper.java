package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface RoleMapper {


    /**
     * 插入数据
     *
     * @param role 数据
     */
    void insert(RoleDTO role);

    /**
     * 更新数据
     *
     * @param role 数据
     */
    void update(RoleDTO role);

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
    RoleDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<RoleDTO> selectByIDs(List<Integer> ids);

    /**
     * 查询代码是否存在
     *
     * @param code          代码
     * @param excludeId     排除ID
     * @param applicationId 应用ID
     * @return 存在数量
     */
    int selectByCodeAndApplication(@Param("code") String code, @Param("excludeId") Integer excludeId, @Param("applicationId") Integer applicationId);
}
