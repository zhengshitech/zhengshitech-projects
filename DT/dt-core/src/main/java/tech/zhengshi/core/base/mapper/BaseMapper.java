package tech.zhengshi.core.base.mapper;


import tech.zhengshi.core.base.domain.BaseDomain;

import java.util.List;
import java.util.Map;

/**
 * @author H
 * @date 2016/12/27
 */
public interface BaseMapper<D extends BaseDomain> {


    void add(D domain);

    void update(D domain);

    void deleteById(Long id);

    D selectById(Long id);

    List<D> selectByIds(List<Long> ids);

    int insertRollback(Long id);

    int deleteRollback(Long id);

    Long updateRollback(Map data);
}
