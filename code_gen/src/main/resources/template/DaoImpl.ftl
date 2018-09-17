package ${base_package_name}.dao.impl;

import com.project.core.base.dao.impl.BaseDaoImpl;
import ${base_package_name}.dao.${base_class_name}Dao;
import ${base_package_name}.domain.${base_class_name}Domain;
import ${base_package_name}.mapper.${base_class_name}Mapper;
import org.springframework.stereotype.Repository;
/**
* 描述：${table_remarks}数据库访问接口实现
* @author ${author}
* @date ${date}
*/
@Repository
public class ${base_class_name}DaoImpl extends BaseDaoImpl<${base_class_name}Mapper,${base_class_name}Domain> implements ${base_class_name}Dao{

}