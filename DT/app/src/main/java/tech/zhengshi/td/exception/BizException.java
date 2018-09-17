package tech.zhengshi.td.exception;

/**
 * @author H
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -3273722906481515831L;

    public BizException(String msg) {
        super(msg);
    }

}
