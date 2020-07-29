package com.bosssoft.Reponse;

import lombok.Data;

/**
 * 统一响应类型
 *
 * @author 吴志鸿
 * @date 2020/7/29
 * @description
 */
@Data
public class Response {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;
}
