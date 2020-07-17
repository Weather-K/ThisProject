package com.aaa.wkn.base;

import static com.aaa.wkn.status.LoginStatus.LOGIN_SUCCESS;

/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/8 16:22
 */
public class BaseController {
    /**
     *
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     *
     * @param msg
     * @return
     */
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *
     * @param data
     * @return
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    
    //TODO 记得按时吃饭
}
