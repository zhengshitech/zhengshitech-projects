package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.DepartmentDao;
import com.z.tech.rbac.dto.DepartmentDTO;
import com.z.tech.rbac.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public void save(DepartmentDTO department) {
        departmentMapper.insert(department);
    }

    @Override
    public void modify(DepartmentDTO department) {

        departmentMapper.update(department);
    }

    @Override
    public void delete(Integer id) {
        departmentMapper.delete(id);
    }

    @Override
    public DepartmentDTO getByID(Integer id) {
        return departmentMapper.selectByID(id);
    }

    @Override
    public List<DepartmentDTO> getByIDs(List<Integer> ids) {
        return departmentMapper.selectByIDs(ids);
    }

    @Override
    public int getMaxMaskNum(int level) {
        Integer maxMaskNum = departmentMapper.selectMaxMaskNum(level);
        return maxMaskNum == null ? 0 : maxMaskNum;
    }
}
