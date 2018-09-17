package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.DepartmentDao;
import com.z.tech.rbac.dto.DepartmentDTO;
import com.z.tech.rbac.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author H
 */
@Service
@Validated
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void save(@Valid DepartmentDTO department) {
        Integer pid = department.getPid();
        DepartmentDTO parent = getByID(pid);
        int targetLevel = 0;
        if (null == parent) {
            //root
        } else {
            targetLevel = parent.getLevel() + 1;
        }
        String myMask = getNextMask(getMaxMaskNum(targetLevel), 3);
        department.setMask(getMask(parent, myMask));
        department.setLevel(targetLevel);
        departmentDao.save(department);
    }



    @Override
    public void modify(@Valid DepartmentDTO department) {
        departmentDao.modify(department);
    }

    @Override
    public void delete(Integer id) {
        departmentDao.delete(id);
    }

    @Override
    public DepartmentDTO getByID(Integer id) {
        return departmentDao.getByID(id);
    }

    @Override
    public List<DepartmentDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个部门ID") List<Integer> ids) {
        return departmentDao.getByIDs(ids);
    }

    private int getMaxMaskNum(int level) {
        return departmentDao.getMaxMaskNum(level);
    }

    private String getNextMask(int currentSort, int maskLength) {
        int nextSort = currentSort + 1;
        String maskSequence = "" + nextSort;
        int currentLength = maskSequence.length();
        StringBuilder sb = new StringBuilder();
        if (currentLength < maskLength) {
            int completionLength = maskLength - currentLength;
            for (int i = 0; i < completionLength; i++) {
                sb.append("0");
            }
        }
        return sb.append(maskSequence).toString();
    }

    private String getMask(DepartmentDTO parent, String myMask) {
        if (null == parent) {
            return myMask;
        } else {
            return parent.getMask() + "_" + myMask;
        }
    }
}
