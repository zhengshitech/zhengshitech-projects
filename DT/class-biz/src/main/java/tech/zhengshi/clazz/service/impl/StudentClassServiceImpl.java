package tech.zhengshi.clazz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.zhengshi.clazz.dao.StudentClassDao;
import tech.zhengshi.clazz.domain.StudentClassDomain;
import tech.zhengshi.clazz.service.StudentClassService;
import tech.zhengshi.core.base.service.impl.BaseServiceImpl;

/**
 * @author H
 */
@Service
public class StudentClassServiceImpl extends BaseServiceImpl<StudentClassDomain, StudentClassDao> implements StudentClassService {
    @Autowired
    private StudentClassDao studentClassDao;
    @Override
    public void removeByStudent(Long studentId) {
        studentClassDao.deleteByStudent(studentId);
    }

    @Override
    public StudentClassDomain getByStudent(Long studentId) {
        return studentClassDao.getByStudent(studentId);
    }

    @Override
    public void rollbackRemoveByStudent(Long studentId) {
        studentClassDao.rollbackRemoveByStudent(studentId);
    }
}
