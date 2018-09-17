package tech.zhengshi.core.dt;

public class UpdateObject implements IDAware {

    private Long id;
    private Object oldDataEntity;


    public UpdateObject() {
    }

    public UpdateObject(IDAware idAware, Object oldDataEntity) {
        this.id = idAware.getId();
        this.oldDataEntity = oldDataEntity;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Object getOldDataEntity() {
        return oldDataEntity;
    }

    public void setOldDataEntity(Object oldDataEntity) {
        this.oldDataEntity = oldDataEntity;
    }
}
