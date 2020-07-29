package com.bosssoft.mapper;

import com.bosssoft.dto.RoleDto;
import com.bosssoft.dto.UserDto;
import com.bosssoft.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RoleMapper extends BaseMapper<Role> {
    List<RoleDto> queryperbyrole();
}
