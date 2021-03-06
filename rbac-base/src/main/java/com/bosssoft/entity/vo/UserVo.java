package com.bosssoft.entity.vo;

import com.bosssoft.entity.po.PermissionsPO;
import com.bosssoft.entity.po.RolePO;
import lombok.Data;

import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/25
 * @description
 */
@Data
public class UserVo {

    /**
     * ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 邮件
     */
    private String email;

    /**
     * 结果标志
     */
    private boolean result;

    /**
     * 登录标志
     */
    private boolean loginmark;

    /**
     * 角色列表
     */
    private List<RolePO> roles;

    /**
     * 权限列表
     */
    private List<PermissionsPO> permissions;

    private String token;

    private Integer code;
}
