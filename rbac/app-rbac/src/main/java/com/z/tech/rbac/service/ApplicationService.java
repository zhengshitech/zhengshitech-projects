package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.ApplicationDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface ApplicationService {
    /**
     * 保存应用
     *
     * @param application 新的应用数据
     */
    void save(@Valid ApplicationDTO application);

    /**
     * 修改应用
     *
     * @param application 旧的应用数据
     */
    void modify(@Valid ApplicationDTO application);

    /**
     * 删除应用数据
     *
     * @param id 应用ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询应用数据
     *
     * @param id 应用ID
     * @return 应用数据
     */
    ApplicationDTO getByID(Integer id);

    /**
     * 根据ID集合查询应用数据
     *
     * @param ids 应用ID集合
     * @return 查询到的应用数据
     */
    List<ApplicationDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个应用ID") List<Integer> ids);

    /**
     * 查询是否有key存在
     * @param key 检测的key
     * @param excludeId 排除的ID
     * @return 是否存在
     */
    boolean getByAppKey(String key, Integer excludeId);
}
