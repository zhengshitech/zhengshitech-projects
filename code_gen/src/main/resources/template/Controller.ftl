package ${base_package_name}.controller;

import ${base_package_name}.dto.${base_class_name}DTO;
import ${base_package_name}.service.${base_class_name}Service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
* 描述：${table_remarks} 控制类
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("/${table_name?lower_case}")
public class ${base_class_name}Controller {

    @Autowired
    private ${base_class_name}Service ${base_class_name?uncap_first}Service;

    @RequestMapping(value = "/saveOne", method = RequestMethod.POST)
    public Long saveOne(@RequestBody ${base_class_name}DTO dto) {
        return ${base_class_name?uncap_first}Service.save(dto);
    }

    @RequestMapping(value = "/modifyOne", method = RequestMethod.POST)
    public Long modifyOne(@RequestBody ${base_class_name}DTO dto) {
        return ${base_class_name?uncap_first}Service.modify(dto);
    }

    @RequestMapping(value = "removeById/{id}", method = RequestMethod.POST)
    public Long removeById(@PathVariable("id") Long id) {
        return ${base_class_name?uncap_first}Service.remove(id);
    }

    @RequestMapping(value = "getByID/{id}", method = RequestMethod.GET)
    public ${base_class_name}DTO getByID(@PathVariable("id") Long id) {
        return ${base_class_name?uncap_first}Service.get(id);
    }

    @RequestMapping(value = "getByIDs", method = RequestMethod.POST)
    public List<${base_class_name}DTO> getByIDs(@RequestBody List<Long> ids) {
        return ${base_class_name?uncap_first}Service.getByIDs(ids);
    }
}