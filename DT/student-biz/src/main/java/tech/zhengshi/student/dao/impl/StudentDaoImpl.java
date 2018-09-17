package tech.zhengshi.student.dao.impl;

import org.springframework.stereotype.Repository;
import tech.zhengshi.core.base.dao.impl.BaseDaoImpl;
import tech.zhengshi.student.dao.StudentDao;
import tech.zhengshi.student.domain.StudentDomain;
import tech.zhengshi.student.mapper.StudentMapper;


/**
 * @author H
 * @date 2017/5/12
 */
@Repository
public class StudentDaoImpl extends BaseDaoImpl<StudentMapper, StudentDomain> implements StudentDao {


}
