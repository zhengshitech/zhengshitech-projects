package com.z.tech.rbac.mapper;

import com.z.tech.rbac.dto.DepartmentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author H
 */
@Mapper
public interface DepartmentMapper {


    /**
     * 插入数据
     *
     * @param department 数据
     */
    void insert(DepartmentDTO department);

    /**
     * 更新数据
     *
     * @param department 数据
     */
    void update(DepartmentDTO department);

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
    DepartmentDTO selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<DepartmentDTO> selectByIDs(List<Integer> ids);

    /**
     * 选择最大序号
     *
     * @param level 层级
     * @return 最大序号
     */
    Integer selectMaxMaskNum(int level);
}
