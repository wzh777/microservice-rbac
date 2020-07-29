package com.bosssoft.service;

import com.bosssoft.dto.PermissionsDto;
import com.bosssoft.dto.RoleDto;
import com.bosssoft.po.Permissions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
public interface PermissionsService {
    boolean updateById(PermissionsDto permissionsDto);

    boolean save(PermissionsDto permissionsDto);

    boolean removeById(PermissionsDto permissionsDto);

    String list();
}
