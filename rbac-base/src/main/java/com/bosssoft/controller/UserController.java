package com.bosssoft.controller;


import com.alibaba.fastjson.JSON;
import com.bosssoft.entity.dto.UserDto;
import com.bosssoft.entity.vo.UserRoleUpdateVO;
import com.bosssoft.entity.vo.UserRoleVo;
import com.bosssoft.entity.vo.UserUpdateVO;
import com.bosssoft.entity.vo.UserVo;
import com.bosssoft.myenum.ResultType;
import com.bosssoft.service.UserService;
import com.bosssoft.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bosssoft.util.ColaBeanUtils;

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
    @ApiOperation(value = "查询用户列表")
    @GetMapping("/querylist")
    public String queryList() {
        List<UserDto> userDtolist = userService.list();
        List<UserVo> userVos = ColaBeanUtils.copyListProperties(userDtolist, UserVo::new);
        if (userVos == null){
            return ResponseUtil.getResponse(null, ResultType.SUCCESS);
        }else {
            return ResponseUtil.getResponse(userVos, ResultType.SUCCESS);
        }
    }

    /**
     * 登录验证
     *
     * @param userVo
     * @return String
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public String login(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserDto userDto1 = userService.login(userDto);
        BeanUtils.copyProperties(userDto1, userVo);
        if (userDto1 == null){
            return ResponseUtil.getResponse(userVo, ResultType.FORBIDDEN);
        }else {
            return ResponseUtil.getResponse(userVo, ResultType.SUCCESS);
        }
    }

    /**
     * 通过名字查询用户
     *
     * @param userVo
     * @return String
     */
    @ApiOperation(value = "通过名字查询用户")
    @PostMapping("/querybyname")
    public String querybyname(@RequestBody UserVo userVo) {
        System.out.println(userVo);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserDto userDto1 = userService.getByName(userDto);
        BeanUtils.copyProperties(userDto1, userVo);
        System.out.println(userVo);
        if (userDto1 == null){
            return ResponseUtil.getResponse(null, ResultType.SUCCESS);
        }else {
            return ResponseUtil.getResponse(userVo, ResultType.SUCCESS);
        }
    }

    /**
     * 修改用户
     *
     * @param userVo
     * @return String
     */
    @ApiOperation(value = "更新用户")
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
    @ApiOperation(value = "添加用户")
    @PostMapping("/adduser")
    public String adduser(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserUpdateVO userUpdateVO = new UserUpdateVO();
        userUpdateVO.setResult(userService.save(userDto));
        return ResponseUtil.getResponse(userUpdateVO, ResultType.SUCCESS);
    }

    /**
     * 删除用户
     *
     * @param userVo
     * @return String
     */
    @ApiOperation(value = "删除用户")
    @PostMapping("/removeuser")
    public String removeuser(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserUpdateVO userUpdateVO = new UserUpdateVO();
        userUpdateVO.setResult(userService.removeById(userDto));
        return ResponseUtil.getResponse(userUpdateVO, ResultType.SUCCESS);
    }

    /**
     * 角色管理
     *
     * @param userRoleVo
     * @return String
     */
    @ApiOperation(value = "用户角色管理")
    @PostMapping("/managerole")
    public String managerole(@RequestBody UserRoleVo userRoleVo) {
        UserRoleUpdateVO userRoleUpdateVO = new UserRoleUpdateVO();
        userRoleUpdateVO.setResult(userService.managerole(userRoleVo));
        return ResponseUtil.getResponse(userRoleUpdateVO, ResultType.SUCCESS);
    }

}