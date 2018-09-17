package tech.zhengshi.core.dt;

import tech.zhengshi.core.base.domain.BaseDomain;

/**
 * Restful 基础操作接口
 *
 * @author H
 */
public abstract class RestfulAware<D extends BaseDomain> implements RestfulBaseAware<D>, RestfulRollbackAware {


}
