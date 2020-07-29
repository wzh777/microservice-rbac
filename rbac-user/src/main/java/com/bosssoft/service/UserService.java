package com.bosssoft.service;

import com.bosssoft.dto.UserDto;
import com.bosssoft.vo.UserRoleVO.UserRoleVo;
import org.springframework.security.core.userdetails.UserDetails;

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


    boolean managerole(UserRoleVo userRoleVo);

}
