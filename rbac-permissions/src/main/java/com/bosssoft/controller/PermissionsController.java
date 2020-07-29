package com.bosssoft.controller;


import com.alibaba.fastjson.JSON;
import com.bosssoft.dto.PermissionsDto;
import com.bosssoft.service.PermissionsService;
import com.bosssoft.vo.PermissionsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/querylist")
    public String queryList() {
        return permissionsService.list();
    }

    @PostMapping("/updateper")
    public String updateuser(@RequestBody PermissionsVo permissionsVo) {
        PermissionsDto permissionsDto = new PermissionsDto();
        BeanUtils.copyProperties(permissionsVo, permissionsDto);
        permissionsVo.setResult(permissionsService.updateById(permissionsDto));
        return JSON.toJSONString(permissionsVo);
    }

    @PostMapping("/addper")
    public String adduser(@RequestBody PermissionsVo permissionsVo) {
        PermissionsDto permissionsDto = new PermissionsDto();
        BeanUtils.copyProperties(permissionsVo, permissionsDto);

        permissionsVo.setResult(permissionsService.save(permissionsDto));
        return JSON.toJSONString(permissionsVo);
    }

    @PostMapping("/removeper")
    public String removeuser(@RequestBody PermissionsVo permissionsVo) {
        PermissionsDto permissionsDto = new PermissionsDto();
        BeanUtils.copyProperties(permissionsVo, permissionsDto);

        permissionsVo.setResult(permissionsService.removeById(permissionsDto));
        return JSON.toJSONString(permissionsVo);
    }

}
