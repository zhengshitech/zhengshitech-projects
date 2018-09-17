package tech.zhengshi.clazz.dao;

import tech.zhengshi.clazz.domain.StudentClassDomain;
import tech.zhengshi.core.base.dao.BaseDao;

/**
 * @author H
 */
public interface StudentClassDao extends BaseDao<StudentClassDomain> {
    void deleteByStudent(Long studentId);

    StudentClassDomain getByStudent(Long studentId);

    void rollbackRemoveByStudent(Long studentId);
}
