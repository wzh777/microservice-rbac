package com.bosssoft.service;

import com.bosssoft.dto.PermissionsDto;
import com.bosssoft.dto.RoleDto;
import com.bosssoft.po.Permissions;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
public interface PermissionsService {
    /**
     * 根据id更新权限
     *
     * @param permissionsDto
     * @return
     */
    boolean updateById(PermissionsDto permissionsDto);

    /**
     * 插入权限
     *
     * @param permissionsDto
     * @return
     */
    boolean save(PermissionsDto permissionsDto);

    /**
     * 根据id删除权限
     *
     * @param permissionsDto
     * @return
     */
    boolean removeById(PermissionsDto permissionsDto);

    /**
     * 查询权限列表
     *
     * @return
     */
    List<PermissionsDto> list();
}
