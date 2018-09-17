package tech.zhengshi.core.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import tech.zhengshi.core.base.domain.BaseDomain;
import tech.zhengshi.core.base.service.BaseService;
import tech.zhengshi.core.dt.RestfulRollbackAware;
import tech.zhengshi.core.dt.UpdateObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengqiang
 * @date 2017/1/10 12:43
 * desc:
 */

public class DTBaseController<D extends BaseDomain, S extends BaseService<D>> extends BaseController implements RestfulRollbackAware {


    @Autowired
    private S service;


    @Override
    public boolean insertRollback(@RequestBody Long id) {
        Long rollbakId = service.insertRollback(id);
        System.out.println("default插入回滚ID:" + rollbakId);
        return true;
    }


    @Override
    public boolean deleteRollback(@RequestBody Long id) {
        Long rollbakId = service.deleteRollback(id);
        System.out.println("default删除回滚ID:" + rollbakId);
        return true;
    }


    @Override
    public boolean updateRollback(@RequestBody UpdateObject object) {
        System.out.println("default更新回滚ID:" + object.getId());
        return true;
    }


    @Override
    public boolean insertBatchRollback(@RequestBody List<Long> ids) {
        System.out.println("default批量插入回滚ID:" + getString(ids));
        return true;
    }

    private String getString(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return "";
        }
        return ids.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    @Override
    public boolean delelteBatchRollback(@RequestBody List<Long> ids) {
        System.out.println("default批量删除回滚ID:" + getString(ids));
        return true;
    }

    @Override
    public boolean updateBatchRollback(@RequestBody List<UpdateObject> objects) {
        List<Long> ids = objects.stream().map(UpdateObject::getId).collect(Collectors.toList());
        System.out.println("default批量修改回滚ID:" + getString(ids));
        return true;
    }


}
