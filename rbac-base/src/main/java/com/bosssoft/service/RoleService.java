package com.bosssoft.service;



import com.bosssoft.entity.dto.RoleDto;
import com.bosssoft.entity.vo.PerRoleVo;

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
    /**
     * 通过ID更新
     * @param roleDto
     * @return
     */
    boolean updateById(RoleDto roleDto);

    /**
     * 插入角色
     * @param roleDto
     * @return
     */
    boolean save(RoleDto roleDto);

    /**
     * 通过id删除角色
     * @param roleDto
     * @return
     */
    boolean removeById(RoleDto roleDto);

    /**
     * 查询角色列表
     * @return
     */
    List<RoleDto> list();

    /**
     * 管理角色权限关系
     * @param perRoleVo
     * @return
     */
    boolean managerole(PerRoleVo perRoleVo);
}
