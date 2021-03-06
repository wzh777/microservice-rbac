package com.bosssoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.bosssoft.entity.dto.RoleDto;
import com.bosssoft.entity.po.RolePO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
@Component
@Repository
public interface RoleMapper extends BaseMapper<RolePO> {
    /**
     * 自定义一对多查询角色列表
     * @return
     */
    List<RoleDto> queryperbyrole();
}
