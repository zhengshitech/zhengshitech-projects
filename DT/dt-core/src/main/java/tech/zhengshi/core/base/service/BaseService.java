package tech.zhengshi.core.base.service;


import tech.zhengshi.core.base.domain.BaseDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by H on 2017/5/12.
 */
public interface BaseService<D extends BaseDomain> {

    void save(D domain);

    void modify(D domain);

    D get(Long id);

    Long remove(Long id);

    List<D> getByIDs(List<Long> ids);

    Long insertRollback(Long id);

    Long deleteRollback(Long id);
    Long updateRollback(Map data);
}
