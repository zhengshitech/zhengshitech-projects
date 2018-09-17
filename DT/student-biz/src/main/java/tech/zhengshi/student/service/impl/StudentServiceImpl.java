package tech.zhengshi.student.service.impl;

import org.springframework.stereotype.Service;
import tech.zhengshi.core.base.service.impl.BaseServiceImpl;
import tech.zhengshi.student.dao.StudentDao;
import tech.zhengshi.student.domain.StudentDomain;
import tech.zhengshi.student.service.StudentService;


/**
 * @author H
 * @date 2017/5/12
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDomain, StudentDao> implements StudentService {


}
