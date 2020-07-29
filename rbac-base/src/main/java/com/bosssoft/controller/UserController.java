package com.bosssoft.controller;


import com.alibaba.fastjson.JSON;
import com.bosssoft.entity.dto.UserDto;
import com.bosssoft.entity.vo.UserRoleUpdateVO;
import com.bosssoft.entity.vo.UserRoleVo;
import com.bosssoft.entity.vo.UserUpdateVO;
import com.bosssoft.entity.vo.UserVo;
import com.bosssoft.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ColaBeanUtils;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @return String
     */
    @GetMapping("/querylist")
    public String queryList() {
        List<UserDto> userDtolist = userService.list();
        List<UserVo> userVos = ColaBeanUtils.copyListProperties(userDtolist, UserVo::new);
        return JSON.toJSONString(userVos);
    }

    /**
     * 登录验证
     *
     * @param userVo
     * @return String
     */
    @PostMapping("/login")
    public String login(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserDto userDto1 = userService.login(userDto);
        BeanUtils.copyProperties(userDto1, userVo);
        return JSON.toJSONString(userVo);
    }

    /**
     * 通过名字查询用户
     *
     * @param userVo
     * @return String
     */
    @PostMapping("/querybyname")
    public String querybyname(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserDto userDto1 = userService.getByName(userDto);
        BeanUtils.copyProperties(userDto1, userVo);
        return JSON.toJSONString(userVo);
    }

    /**
     * 修改用户
     *
     * @param userVo
     * @return String
     */
    @PostMapping("/updateuser")
    public String updateuser(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserUpdateVO userUpdateVO = new UserUpdateVO();
        userUpdateVO.setResult(userService.updateById(userDto));
        return JSON.toJSONString(userUpdateVO);
    }

    /**
     * 添加用户
     *
     * @param userVo
     * @return String
     */
    @PostMapping("/adduser")
    public String adduser(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserUpdateVO userUpdateVO = new UserUpdateVO();
        userUpdateVO.setResult(userService.save(userDto));
        return JSON.toJSONString(userUpdateVO);
    }

    /**
     * 删除用户
     *
     * @param userVo
     * @return String
     */
    @PostMapping("/removeuser")
    public String removeuser(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserUpdateVO userUpdateVO = new UserUpdateVO();
        userUpdateVO.setResult(userService.removeById(userDto));
        return JSON.toJSONString(userUpdateVO);
    }

    /**
     * 角色管理
     *
     * @param userRoleVo
     * @return String
     */
    @PostMapping("/managerole")
    public String managerole(@RequestBody UserRoleVo userRoleVo) {
        UserRoleUpdateVO userRoleUpdateVO = new UserRoleUpdateVO();
        userRoleUpdateVO.setResult(userService.managerole(userRoleVo));
        return JSON.toJSONString(userRoleUpdateVO);
    }

}