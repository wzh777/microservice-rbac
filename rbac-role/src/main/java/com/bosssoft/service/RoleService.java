package com.bosssoft.service;

import com.bosssoft.dto.RoleDto;
import com.bosssoft.vo.PerRoleVo;

import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
public interface RoleService {
    boolean updateById(RoleDto roleDto);

    boolean save(RoleDto roleDto);

    boolean removeById(RoleDto roleDto);

    List<RoleDto> list();

    boolean managerole(PerRoleVo perRoleVo);
}
