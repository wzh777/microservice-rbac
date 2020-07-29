package com.bosssoft.service.imp;

import com.bosssoft.service.PermissionsService;
import com.bosssoft.entity.dto.PermissionsDto;
import com.bosssoft.entity.po.PermissionsPO;
import com.bosssoft.mapper.PermissionsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bosssoft.util.ColaBeanUtils;

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
        PermissionsPO permissions = new PermissionsPO();
        BeanUtils.copyProperties(permissionsDto, permissions);
        int result = permissionsMapper.updateById(permissions);
        return result == 1;
    }

    /**
     * 插入权限
     *
     * @param permissionsDto
     * @return
     */
    @Override
    public boolean save(PermissionsDto permissionsDto) {
        PermissionsPO permissions = new PermissionsPO();
        BeanUtils.copyProperties(permissionsDto, permissions);
        int result = permissionsMapper.insert(permissions);
        return result == 1;
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
        return result == 1;
    }

    /**
     * 获取权限列表
     *
     * @return List<PermissionsDto>
     */
    @Override
    public List<PermissionsDto> list() {
        List<PermissionsPO> permissions = permissionsMapper.selectList(null);
        return ColaBeanUtils.copyListProperties(permissions, PermissionsDto::new);
    }

}
