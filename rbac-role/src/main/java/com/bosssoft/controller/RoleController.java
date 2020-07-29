package com.bosssoft.controller;


import com.alibaba.fastjson.JSON;
import com.bosssoft.dto.RoleDto;
import com.bosssoft.service.RoleService;
import com.bosssoft.vo.PerRoleVo;
import com.bosssoft.vo.RoleVO.RoleVo;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/querylist")
    public String queryList() {
        List<RoleDto> list = roleService.list();
        List<RoleVo> roleVos = ColaBeanUtils.copyListProperties(list, RoleVo::new);

        return JSON.toJSONString(roleVos);
    }

    @PostMapping("/updaterole")
    public String updateuser(@RequestBody RoleVo roleVo) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleVo, roleDto);
        roleVo.setResult(roleService.updateById(roleDto));
        return JSON.toJSONString(roleVo);
    }

    @PostMapping("/addrole")
    public String adduser(@RequestBody RoleVo roleVo) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleVo, roleDto);
        roleVo.setResult(roleService.save(roleDto));
        return JSON.toJSONString(roleVo);
    }

    @PostMapping("/removerole")
    public String removeuser(@RequestBody RoleVo roleVo) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleVo, roleDto);
        roleVo.setResult(roleService.removeById(roleDto));
        return JSON.toJSONString(roleVo);
    }

    @PostMapping("/managepermisssions")
    public String managerole(@RequestBody PerRoleVo perRoleVo) {
        perRoleVo.setResult(roleService.managerole(perRoleVo));
        return JSON.toJSONString(perRoleVo);
    }

}

