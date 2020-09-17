package com.voyage.controller;

import com.voyage.common.ResponseMO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@Author: kangb on 2020/9/16 23:57
 *@param:
 *@return:
 *@Description:  基础控制器
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    public <T> ResponseMO<T> success(T resMo, String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setMsg(msg);
        responseMO.setData(resMo);
        return responseMO;
    }

    public <T> ResponseMO<T> success(T resMo) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setData(resMo);
        return responseMO;
    }

    public <T> ResponseMO<T> success() {
        return new ResponseMO<>();
    }

    public <T> ResponseMO<T> success(String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setMsg(msg);
        return responseMO;
    }

    public <T> ResponseMO<T> error(T resMo, String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setResponseCodeFailure();
        responseMO.setMsg(msg);
        responseMO.setData(resMo);
        return responseMO;
    }

    public <T> ResponseMO<T> error(String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setResponseCodeFailure();
        responseMO.setMsg(msg);
        return responseMO;
    }

    public <T> ResponseMO<T> custom(int code, String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setCode(code);
        responseMO.setMsg(msg);
        return responseMO;
    }

    public <T> ResponseMO<T> custom(T resMo, int code, String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setCode(code);
        responseMO.setMsg(msg);
        responseMO.setData(resMo);
        return responseMO;
    }

    public <T> ResponseMO<T> errorCode(String errorCode, String msg) {
        ResponseMO<T> responseMO = new ResponseMO<T>();
        responseMO.setResponseCodeFailure();
        responseMO.setMsg(msg);
        responseMO.setDebugInfo(errorCode);
        return responseMO;
    }
}
