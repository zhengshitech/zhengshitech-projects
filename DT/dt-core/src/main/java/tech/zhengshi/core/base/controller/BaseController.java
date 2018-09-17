package tech.zhengshi.core.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tech.zhengshi.core.base.domain.BaseDomain;
import tech.zhengshi.core.base.service.BaseService;
import tech.zhengshi.core.dt.RestfulBaseAware;

import java.util.List;
import java.util.Map;

/**
 * @author zhengqiang
 * @date 2017/1/10 12:43
 * desc:
 */

public class BaseController<D extends BaseDomain, S extends BaseService<D>> implements RestfulBaseAware<D> {


    @Autowired
    private S service;

    @Override
    public Long save(@RequestBody D domain) {
        service.save(domain);
        return  domain.getId();
    }


    @Override
    public Long modify(@RequestBody D domain) {
        service.modify(domain);
        return  domain.getId();
    }

    @Override
    public Long remove(@PathVariable("id") Long id) {
        Long remove = service.remove(id);
        System.out.println("删除成功,ID:" + id);
        return remove;
    }

    @Override
    public D get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @Override
    public List<D> getByIDs(@RequestBody List<Long> ids) {
        return service.getByIDs(ids);
    }

    @Override
    public Long updateRollBack(@RequestBody Map data) {
        Long id = (Long) data.get("id");
        service.updateRollback(data);
        return id;
    }
}
