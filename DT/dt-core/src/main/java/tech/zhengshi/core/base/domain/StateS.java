package tech.zhengshi.core.base.domain;

public enum StateS {

    NORMAL(1, "正常"),
    DELETE(2, "删除"),
    ROLLBACK(3, "回滚");


    private final Integer key;
    private final String value;

    StateS(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
