package tech.zhengshi.core.dt;

import org.springframework.web.bind.annotation.*;
import tech.zhengshi.core.base.domain.BaseDomain;

import java.util.List;
import java.util.Map;

/**
 * Restful 基础操作接口
 *
 * @author H
 */
public interface RestfulBaseAware<D extends BaseDomain> {

    @RequestMapping(value = "save", method = RequestMethod.POST)
    Long save(@RequestBody D domain);


    @RequestMapping(value = "modify", method = RequestMethod.POST)
    Long modify(@RequestBody D domain);


    @RequestMapping(value = "remove/{id}", method = RequestMethod.POST)
    Long remove(@PathVariable("id") Long id);

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    D get(@PathVariable("id") Long id);

    @PostMapping(value = "getByIDs")
    List<D> getByIDs(@RequestBody List<Long> ids);


    @RequestMapping(value = "updateRollBack", method = RequestMethod.POST)
    Long updateRollBack(@RequestBody Map data);

}
