package tech.zhengshi.core.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tech.zhengshi.core.base.dao.BaseDao;
import tech.zhengshi.core.base.domain.BaseDomain;
import tech.zhengshi.core.base.service.BaseService;


import java.util.List;
import java.util.Map;

/**
 * @author H
 * @date 2017/5/12
 */
public class BaseServiceImpl<D extends BaseDomain, S extends BaseDao<D>> implements BaseService<D> {

    @Autowired
    private S baseDao;

    @Override
    public void save(D domain) {
        baseDao.insert(domain);

    }

    @Override
    public void modify(D domain) {
        baseDao.update(domain);

    }

    @Override
    public D get(Long id) {
        return baseDao.get(id);
    }

    @Override
    public List<D> getByIDs(List<Long> ids) {
        return baseDao.getByIDs(ids);
    }

    @Override
    public Long insertRollback(Long id) {
        return baseDao.insertRollback(id);
    }

    @Override
    public Long deleteRollback(Long id) {
        return baseDao.deleteRollback(id);
    }

    @Override
    public Long updateRollback(Map data) {
        return baseDao.updateRollback(data);
    }

    @Override
    public Long remove(Long id) {
        baseDao.delete(id);
        return id;
    }



}
