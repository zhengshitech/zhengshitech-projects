package com.z.tech.rbac.dao;

import java.util.List;

public interface BaseTableDao<TableDomain> {
    /**
     * 保存
     *
     * @param domain 数据
     */
    void save(TableDomain domain);

    /**
     * 修改
     *
     * @param domain 数据
     */
    void modify(TableDomain domain);

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
    TableDomain getByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 数据集合
     */
    List<TableDomain> getByIDs(List<Integer> ids);
}
