package ${base_package_name}.service.impl;

import com.project.core.base.service.impl.BaseServiceImpl;
import ${base_package_name}.dao.${base_class_name}Dao;
import ${base_package_name}.domain.${base_class_name}Domain;
import ${base_package_name}.dto.${base_class_name}DTO;
import ${base_package_name}.service.${base_class_name}Service;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* 描述：${table_remarks}服务接口实现
* @author ${author}
* @date ${date}
*/
@Service
public class ${base_class_name}ServiceImpl extends BaseServiceImpl<${base_class_name}DTO,${base_class_name}Domain,${base_class_name}Dao> implements ${base_class_name}Service  {

    @Override
    public List<${base_class_name}Domain> toDomains(List<${base_class_name}DTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return new ArrayList<>(0);
        }
        return dtos.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<${base_class_name}DTO> toDTOs(List<${base_class_name}Domain> domains) {
        if (CollectionUtils.isEmpty(domains)) {
            return new ArrayList<>(0);
        }
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ${base_class_name}DTO toDTO(${base_class_name}Domain domain) {
        ${base_class_name}DTO dto = new ${base_class_name}DTO();
        if(null==domain){
            return dto;
        }
        <#list columns as model>
        dto.set${model.javaFieldName?cap_first}(domain.get${model.javaFieldName?cap_first}());
        </#list>
        return dto;
    }
    @Override
    public ${base_class_name}Domain toDomain(${base_class_name}DTO dto) {
        ${base_class_name}Domain domain = new ${base_class_name}Domain();
        if(null==dto){
            return domain;
        }
        <#list columns as model>
        domain.set${model.javaFieldName?cap_first}(dto.get${model.javaFieldName?cap_first}());
        </#list>
        return domain;
    }
}