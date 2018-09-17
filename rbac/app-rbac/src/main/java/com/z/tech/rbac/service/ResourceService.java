package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.ResourceDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface ResourceService {
    /**
     * 保存资源
     *
     * @param resource 新的资源数据
     */
    void save(@Valid ResourceDTO resource);

    /**
     * 修改资源
     *
     * @param resource 旧的资源数据
     */
    void modify(@Valid ResourceDTO resource);

    /**
     * 删除资源数据
     *
     * @param id 资源ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询资源数据
     *
     * @param id 资源ID
     * @return 资源数据
     */
    ResourceDTO getByID(Integer id);

    /**
     * 根据ID集合查询资源数据
     *
     * @param ids 资源ID集合
     * @return 查询到的资源数据
     */
    List<ResourceDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个资源ID") List<Integer> ids);


    /**
     * 查询代码是否存在
     *
     * @param resourceKey   代码
     * @param excludeId     排除ID
     * @param applicationId 应用ID
     * @param type          类型
     * @return 是否存在
     */
    boolean getByResourceKeyAndApplication(String resourceKey, Integer excludeId, Integer applicationId, Integer type);

    /**
     * 查询一个应用的资源
     *
     * @param applicationId 应用
     * @param type          类型
     * @return 资源
     */
    List<ResourceDTO> getByApplication(Integer applicationId, Integer type);
}
