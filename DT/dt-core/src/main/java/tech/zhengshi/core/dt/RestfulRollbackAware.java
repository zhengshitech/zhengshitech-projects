package tech.zhengshi.core.dt;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Restful 分布式补偿接口
 *
 * @author H
 */
public interface RestfulRollbackAware {

    @PostMapping(value = "insertRollback")
    boolean insertRollback(@RequestBody Long id);


    @PostMapping(value = "deleteRollback")
    boolean deleteRollback(@RequestBody Long id);


    @PostMapping(value = "updateRollback")
    boolean updateRollback(@RequestBody UpdateObject object);


    @PostMapping(value = "insertBatchRollback")
    boolean insertBatchRollback(@RequestBody List<Long> ids);

    @PostMapping(value = "delelteBatchRollback")
    boolean delelteBatchRollback(@RequestBody List<Long> ids);

    @PostMapping(value = "updateBatchRollback")
    boolean updateBatchRollback(@RequestBody List<UpdateObject> objects);



}
