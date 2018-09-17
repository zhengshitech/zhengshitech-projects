package tech.zhengshi.core.base.domain;

import tech.zhengshi.core.dt.IDAware;

/**
 * @author H
 */
public class BaseDomain implements IDAware {

    private Long id;

    private Integer s;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }
}
