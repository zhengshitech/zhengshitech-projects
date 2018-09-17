package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.TenantDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface TenantMapper {


    /**
     * 插入数据
     *
     * @param newTenant 数据
     */
    void insert(TenantDTO newTenant);

    /**
     * 更新数据
     *
     * @param oldTenant 数据
     */
    void update(TenantDTO oldTenant);

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
    TenantDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<TenantDTO> selectByIDs(List<Integer> ids);

    /**
     * 选择最大序号
     *
     * @param level 层级
     * @return 最大序号
     */
    Integer selectMaxMaskNum(int level);
}
