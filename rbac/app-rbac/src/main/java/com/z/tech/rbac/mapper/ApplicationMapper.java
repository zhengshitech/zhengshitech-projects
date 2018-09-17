package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.ApplicationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface ApplicationMapper {


    /**
     * 插入数据
     *
     * @param application 数据
     */
    void insert(ApplicationDTO application);

    /**
     * 更新数据
     *
     * @param application 数据
     */
    void update(ApplicationDTO application);

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
    ApplicationDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<ApplicationDTO> selectByIDs(List<Integer> ids);

    /**
     * 查询是否有key存在
     *
     * @param appKey    检测的key
     * @param excludeId 排除的ID
     * @return 数量
     */
    int selectByAppKey(@Param("appKey") String appKey, @Param("excludeId") Integer excludeId);

}
