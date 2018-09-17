package ${base_package_name}.mapper;

import com.project.core.base.mapper.BaseMapper;
import ${base_package_name}.domain.${base_class_name}Domain;
import org.apache.ibatis.annotations.Mapper;
/**
* 描述：${table_remarks}mybatis映射接口
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${base_class_name}Mapper extends BaseMapper<${base_class_name}Domain> {

}