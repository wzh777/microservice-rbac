package com.bosssoft.dto;

import com.bosssoft.po.Permissions;
import com.bosssoft.po.Role;
import lombok.Data;

import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/25
 * @description
 */
@Data
public class UserDto {

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
    private List<Role> roles;

    /**
     * 权限列表
     */
    private List<Permissions> permissions;
}
