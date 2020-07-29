package com.bosssoft.controller;


import com.alibaba.fastjson.JSON;
import com.bosssoft.dto.PermissionsDto;
import com.bosssoft.service.PermissionsService;
import com.bosssoft.vo.PermissionsVo;
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
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    /**
     * 查询权限列表
     *
     * @return
     */
    @GetMapping("/querylist")
    public String queryList() {
        List<PermissionsDto> list = permissionsService.list();
        List<PermissionsVo> permissionsVos = ColaBeanUtils.copyListProperties(list, PermissionsVo::new);
        return JSON.toJSONString(permissionsVos);
    }

    /**
     * 修改权限
     *
     * @param permissionsVo
     * @return
     */
    @PostMapping("/updateper")
    public String updateuser(@RequestBody PermissionsVo permissionsVo) {
        PermissionsDto permissionsDto = new PermissionsDto();
        BeanUtils.copyProperties(permissionsVo, permissionsDto);
        permissionsVo.setResult(permissionsService.updateById(permissionsDto));
        return JSON.toJSONString(permissionsVo);
    }

    /**
     * 插入权限
     *
     * @param permissionsVo
     * @return
     */
    @PostMapping("/addper")
    public String adduser(@RequestBody PermissionsVo permissionsVo) {
        PermissionsDto permissionsDto = new PermissionsDto();
        BeanUtils.copyProperties(permissionsVo, permissionsDto);
        permissionsVo.setResult(permissionsService.save(permissionsDto));
        return JSON.toJSONString(permissionsVo);
    }

    /**
     * 删除权限
     *
     * @param permissionsVo
     * @return
     */
    @PostMapping("/removeper")
    public String removeuser(@RequestBody PermissionsVo permissionsVo) {
        PermissionsDto permissionsDto = new PermissionsDto();
        BeanUtils.copyProperties(permissionsVo, permissionsDto);
        permissionsVo.setResult(permissionsService.removeById(permissionsDto));
        return JSON.toJSONString(permissionsVo);
    }

}

