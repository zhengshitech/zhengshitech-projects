package com.z.tech.rbac.dao;

import com.z.tech.rbac.dto.DepartmentDTO;

import java.util.List;

/**
 * @author H
 */
public interface DepartmentDao {
    /**
     * 保存
     *
     * @param department 数据
     */
    void save(DepartmentDTO department);

    /**
     * 修改
     *
     * @param department 数据
     */
    void modify(DepartmentDTO department);

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
    DepartmentDTO getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<DepartmentDTO> getByIDs(List<Integer> ids);

    /**
     * 获取最大的层次掩码序号
     * @param level 层级
     * @return 最大序号
     */
    int getMaxMaskNum(int level);
}
