package tech.zhengshi.student.mapper;


import org.apache.ibatis.annotations.Mapper;
import tech.zhengshi.core.base.mapper.BaseMapper;
import tech.zhengshi.student.domain.StudentDomain;


/**
 * @author H
 * @date 2016/12/27
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentDomain> {


}
