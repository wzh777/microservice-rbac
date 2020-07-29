package com.bosssoft.util;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.Reponse.Response;
import com.bosssoft.myenum.ResultType;


/**
 * 统一响应结果 工具类
 *
 * @author AloneH
 * @date 2020-07-25
 */
public class ResponseUtil {

    public static String getResponse(Object content, ResultType code) {
        Response outputParam = new Response();
        outputParam.setData(content);
        outputParam.setStatus(code.getCode());
        outputParam.setMsg(code.getMsg());
        return JSONObject.toJSONString(outputParam);
    }

    public static String getResponse(ResultType code) {
        Response outputParam = new Response();
        outputParam.setData(new Object());
        outputParam.setStatus(code.getCode());
        outputParam.setMsg(code.getMsg());
        return JSONObject.toJSONString(outputParam);
    }

    public static String getResponse(Integer code, String msg, Object content) {
        Response outputParam = new Response();
        outputParam.setData(content);
        outputParam.setStatus(code);
        outputParam.setMsg(msg);
        return JSONObject.toJSONString(outputParam);
    }

    public static String getResponse(Integer code, String msg) {
        Response outputParam = new Response();
        outputParam.setData(new Object());
        outputParam.setStatus(code);
        outputParam.setMsg(msg);
        return JSONObject.toJSONString(outputParam);
    }

}
