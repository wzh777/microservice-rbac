package com.bosssoft.mapper;

import com.bosssoft.dto.UserDto;
import com.bosssoft.po.User;
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
public interface UserMapper extends BaseMapper<User> {

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
