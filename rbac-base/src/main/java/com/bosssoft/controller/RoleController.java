package com.bosssoft.controller;


import com.alibaba.fastjson.JSON;
import com.bosssoft.entity.dto.RoleDto;
import com.bosssoft.entity.vo.PerRoleVo;
import com.bosssoft.entity.vo.RoleVo;
import com.bosssoft.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询角色列表
     * @return
     */
    @GetMapping("/querylist")
    public String queryList() {
        List<RoleDto> list = roleService.list();
        List<RoleVo> roleVos = ColaBeanUtils.copyListProperties(list, RoleVo::new);
        return JSON.toJSONString(roleVos);
    }

    /**
     * 更新角色
     * @param roleVo
     * @return
     */
    @PostMapping("/updaterole")
    public String updateuser(@RequestBody RoleVo roleVo) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleVo, roleDto);
        roleVo.setResult(roleService.updateById(roleDto));
        return JSON.toJSONString(roleVo);
    }

    /**
     * 添加角色
     * @param roleVo
     * @return
     */
    @PostMapping("/addrole")
    public String adduser(@RequestBody RoleVo roleVo) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleVo, roleDto);
        roleVo.setResult(roleService.save(roleDto));
        return JSON.toJSONString(roleVo);
    }

    /**
     * 删除角色
     * @param roleVo
     * @return
     */
    @PostMapping("/removerole")
    public String removeuser(@RequestBody RoleVo roleVo) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleVo, roleDto);
        roleVo.setResult(roleService.removeById(roleDto));
        return JSON.toJSONString(roleVo);
    }

    /**
     * 修改角色权限列表
     * @param perRoleVo
     * @return
     */
    @PostMapping("/managepermisssions")
    public String managerole(@RequestBody PerRoleVo perRoleVo) {
        perRoleVo.setResult(roleService.managerole(perRoleVo));
        return JSON.toJSONString(perRoleVo);
    }

}

