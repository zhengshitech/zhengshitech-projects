package tech.zhengshi.clazz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.zhengshi.clazz.domain.StudentClassDomain;
import tech.zhengshi.core.base.mapper.BaseMapper;

/**
 * @author H
 */
@Mapper
public interface StudentClassMapper extends BaseMapper<StudentClassDomain> {

    StudentClassDomain getByStudent(@Param("studentId") Long studentId);

    void deleteByStudent(@Param("studentId") Long studentId);

    void rollbackRemoveByStudent(@Param("studentId") Long studentId);
}
