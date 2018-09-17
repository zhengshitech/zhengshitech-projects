package tech.zhengshi.core.base.dao;


import tech.zhengshi.core.base.domain.BaseDomain;

import java.util.List;
import java.util.Map;

/**
 * @author H
 * @date 2017/5/12
 */
public interface BaseDao<D extends BaseDomain> {
    void insert(D domain);

    void update(D domain);

    D get(Long id);

    void delete(Long id);

    List<D> getByIDs(List<Long> ids);

    Long insertRollback(Long id);

    Long deleteRollback(Long id);

    Long updateRollback(Map data);
}
