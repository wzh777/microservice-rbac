package com.bosssoft.entity.dto;

import lombok.Data;

/**
 * @author 吴志鸿
 * @date 2020/7/26
 * @description
 */
@Data
public class PermissionsDto {

    /**
     * ID
     */
    private Integer id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 结果标志
     */
    private boolean result;
}
