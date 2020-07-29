package com.bosssoft.service.imp;

import com.bosssoft.entity.dto.PermissionsDto;
import com.bosssoft.entity.po.Permissions;
import com.bosssoft.mapper.PermissionsMapper;
import com.bosssoft.service.PermissionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ColaBeanUtils;

import java.util.List;

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

    /**
     * 根据id更新权限
     *
     * @param permissionsDto
     * @return
     */
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

    /**
     * 插入权限
     *
     * @param permissionsDto
     * @return
     */
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

    /**
     * 根据id删除权限
     *
     * @param permissionsDto
     * @return
     */
    @Override
    public boolean removeById(PermissionsDto permissionsDto) {
        int result = permissionsMapper.deleteById(permissionsDto.getId());
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取权限列表
     *
     * @return List<PermissionsDto>
     */
    @Override
    public List<PermissionsDto> list() {
        List<Permissions> permissions = permissionsMapper.selectList(null);
        List<PermissionsDto> permissionsDtos = ColaBeanUtils.copyListProperties(permissions, PermissionsDto::new);
        return permissionsDtos;
    }

}
