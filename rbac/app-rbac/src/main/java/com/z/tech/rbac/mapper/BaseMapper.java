package com.z.tech.rbac.mapper;

import java.util.List;

/**
 * @author H
 */
public interface BaseMapper<T> {

    /**
     * 插入数据
     *
     * @param application 数据
     */
    void insert(T application);

    /**
     * 更新数据
     *
     * @param application 数据
     */
    void update(T application);

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
    T selectByID(Integer id);

    /**
     * 根据ID集合查询
     *
     * @param ids ID集合
     * @return 租户数据
     */
    List<T> selectByIDs(List<Integer> ids);


}
