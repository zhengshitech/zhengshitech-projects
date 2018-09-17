package tech.zhengshi.core.base.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tech.zhengshi.core.base.dao.BaseDao;
import tech.zhengshi.core.base.domain.BaseDomain;
import tech.zhengshi.core.base.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author H
 * @date 2017/5/12
 */
public class BaseDaoImpl<M extends BaseMapper<D>, D extends BaseDomain> implements BaseDao<D> {

    @Autowired
    private M mapper;

    @Override
    public void insert(D domain) {
        mapper.add(domain);
    }

    @Override
    public void update(D domain) {
        mapper.update(domain);
    }


    @Override
    public D get(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<D> getByIDs(List<Long> ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public Long insertRollback(Long id) {
        int affectRows = mapper.insertRollback(id);
        return id;
    }

    @Override
    public Long deleteRollback(Long id) {
        int affectRows = mapper.deleteRollback(id);
        return id;
    }

    @Override
    public Long updateRollback(Map data) {
        return mapper.updateRollback(data);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }


}
