package com.z.tech.rbac.service;

import com.z.tech.rbac.dto.DepartmentDTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
public interface DepartmentService {
    /**
     * 保存部门
     *
     * @param department 新的部门数据
     */
    void save(@Valid DepartmentDTO department);

    /**
     * 修改部门
     *
     * @param department 旧的部门数据
     */
    void modify(@Valid DepartmentDTO department);

    /**
     * 删除部门数据
     *
     * @param id 部门ID
     */
    void delete(Integer id);

    /**
     * 根据ID查询部门数据
     *
     * @param id 部门ID
     * @return 部门数据
     */
    DepartmentDTO getByID(Integer id);

    /**
     * 根据ID集合查询部门数据
     *
     * @param ids 部门ID集合
     * @return 查询到的部门数据
     */
    List<DepartmentDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个部门ID") List<Integer> ids);
}
