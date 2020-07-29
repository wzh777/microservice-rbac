package com.bosssoft.entity.vo;


import com.bosssoft.entity.po.PermissionsPO;
import lombok.Data;

import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/26
 * @description
 */
@Data
public class RoleVo {

    /**
     * ID
     */
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 结果标志
     */
    private boolean result;

    /**
     * 权限列表
     */
    private List<PermissionsPO> permissions;
}
