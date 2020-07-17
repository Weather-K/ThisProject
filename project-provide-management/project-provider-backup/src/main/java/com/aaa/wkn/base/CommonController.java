package com.aaa.wkn.base;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/10 9:13
 */
public abstract class CommonController<T> extends  BaseController {

    protected void beforeAdd(Map map) {
        // TODO AddMethod Before to do something
    }

    protected void afterAdd(Map map) {
        // TODO AddMethod After to do something
    }

    public abstract BaseService<T> getBaseService();

    public ResultData add(@RequestBody Map map) {
        // 因为根据咱们的封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类
        // 但是controller是一个Map类型
        beforeAdd(map);
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        // 2.通用service
        Integer addResult = getBaseService().add(instance);
        if(addResult > 0) {
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }


    public ResultData delete(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids) {
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
}
