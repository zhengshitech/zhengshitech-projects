package tech.zhengshi.clazz.service;

import tech.zhengshi.clazz.domain.StudentClassDomain;
import tech.zhengshi.core.base.service.BaseService;

/**
 * @author H
 */
public interface StudentClassService extends BaseService<StudentClassDomain> {
    void removeByStudent(Long studentId);

    StudentClassDomain getByStudent(Long studentId);

    void rollbackRemoveByStudent(Long studentId);
}
