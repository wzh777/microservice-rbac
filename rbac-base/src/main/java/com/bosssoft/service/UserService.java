package com.bosssoft.service;


import com.bosssoft.entity.dto.UserDto;
import com.bosssoft.entity.vo.UserRoleVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
public interface UserService {
    /**
     * 通过id修改用户信息
     *
     * @param userDto
     * @return boolean值
     */
    boolean updateById(UserDto userDto);

    /**
     * 插入用户
     *
     * @param userDto
     * @return boolean值
     */
    boolean save(UserDto userDto);

    /**
     * 删除用户
     *
     * @param userDto
     * @return boolean值
     */
    boolean removeById(UserDto userDto);

    /**
     * 查询用户列表
     *
     * @param
     * @return List
     */
    List<UserDto> list();

    /**
     * 通过名字查询用户
     *
     * @param userDto
     * @return UserDto
     */
    UserDto getByName(UserDto userDto);

    /**
     * 登录验证接口
     *
     * @param userDto
     * @return UserDto
     */
    UserDto login(UserDto userDto);


    /**
     * 管理用户角色关系
     * @param userRoleVo
     * @return
     */
    boolean managerole(UserRoleVo userRoleVo);

}
