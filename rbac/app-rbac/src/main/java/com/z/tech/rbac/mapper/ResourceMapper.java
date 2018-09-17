package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.ResourceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface ResourceMapper {


    /**
     * 插入数据
     *
     * @param resource 数据
     */
    void insert(ResourceDTO resource);

    /**
     * 更新数据
     *
     * @param resource 数据
     */
    void update(ResourceDTO resource);

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
    ResourceDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<ResourceDTO> selectByIDs(List<Integer> ids);

    /**
     * 查询代码是否存在
     *
     * @param resourceKey   代码
     * @param excludeId     排除ID
     * @param applicationId 应用ID
     * @param type          类型
     * @return 存在数量
     */
    int selectByResourceKeyAndApplication(@Param("resourceKey") String resourceKey, @Param("excludeId") Integer excludeId, @Param("applicationId") Integer applicationId, @Param("type") Integer type);

    /**
     * 查询一个应用的资源
     *
     * @param applicationId 应用
     * @param type          类型
     * @return 资源
     */
    List<ResourceDTO> selectByApplication(@Param("applicationId") Integer applicationId, @Param("type") Integer type);
}
