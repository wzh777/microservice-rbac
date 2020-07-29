package com.bosssoft.entity.vo;

import lombok.Data;

/**
 * @author 吴志鸿
 * @date 2020/7/27
 * @description
 */
@Data
public class PerRoleVo {
    /**
     * 前端返回的权限列表
     */
    private Object permissionsList;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 结果标志
     */
    private boolean result;
}
