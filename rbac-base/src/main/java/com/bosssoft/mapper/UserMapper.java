package com.bosssoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bosssoft.entity.dto.UserDto;
import com.bosssoft.entity.po.UserPO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/29
 * @description
 */
@Component
public interface UserMapper extends BaseMapper<UserPO> {
    /**
     * 自定义一对多查询接口，通过用户名查询出用户信息，包括用户的角色和权限
     *
     * @param name 用户名
     * @return UserDto
     */
    UserDto queryper(String name);

    /**
     * 一对多查询用户权限
     *
     * @param
     * @return UserDto
     */
    List<UserDto> queryperList();

}
