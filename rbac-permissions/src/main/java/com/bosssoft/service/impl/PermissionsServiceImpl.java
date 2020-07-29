package com.bosssoft.service.impl;

import com.alibaba.fastjson.JSON;
import com.bosssoft.dto.PermissionsDto;
import com.bosssoft.dto.RoleDto;
import com.bosssoft.po.Permissions;
import com.bosssoft.mapper.PermissionsMapper;
import com.bosssoft.po.Role;
import com.bosssoft.service.PermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public boolean updateById(PermissionsDto permissionsDto) {
        Permissions permissions = new Permissions();
        BeanUtils.copyProperties(permissionsDto, permissions);
        int result = permissionsMapper.updateById(permissions);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(PermissionsDto permissionsDto) {
        Permissions permissions = new Permissions();
        BeanUtils.copyProperties(permissionsDto, permissions);
        int result = permissionsMapper.insert(permissions);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeById(PermissionsDto permissionsDto) {
        int result = permissionsMapper.deleteById(permissionsDto.getId());
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String list() {
        return JSON.toJSONString(permissionsMapper.selectList(null));
    }

}
