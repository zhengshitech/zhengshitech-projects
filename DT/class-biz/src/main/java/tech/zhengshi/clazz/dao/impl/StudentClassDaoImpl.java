package tech.zhengshi.clazz.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.zhengshi.clazz.dao.StudentClassDao;
import tech.zhengshi.clazz.domain.StudentClassDomain;
import tech.zhengshi.clazz.mapper.StudentClassMapper;
import tech.zhengshi.core.base.dao.impl.BaseDaoImpl;

/**
 * @author H
 */
@Repository
public class StudentClassDaoImpl extends BaseDaoImpl<StudentClassMapper, StudentClassDomain> implements StudentClassDao {
    @Autowired
    private StudentClassMapper studentClassMapper;

    @Override
    public void deleteByStudent(Long studentId) {
        studentClassMapper.deleteByStudent(studentId);
    }

    @Override
    public StudentClassDomain getByStudent(Long studentId) {
        return studentClassMapper.getByStudent(studentId);
    }

    @Override
    public void rollbackRemoveByStudent(Long studentId) {
        studentClassMapper.rollbackRemoveByStudent(studentId);
    }
}
