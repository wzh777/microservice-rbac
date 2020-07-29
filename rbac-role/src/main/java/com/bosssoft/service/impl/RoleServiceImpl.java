package com.bosssoft.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bosssoft.dto.RoleDto;
import com.bosssoft.dto.UserDto;
import com.bosssoft.mapper.PerRoleMapper;
import com.bosssoft.po.PerRole;
import com.bosssoft.po.Role;
import com.bosssoft.mapper.RoleMapper;
import com.bosssoft.po.User;
import com.bosssoft.po.UserRole;
import com.bosssoft.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bosssoft.vo.PerRoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PerRoleMapper perRoleMapper;

    /**
     * 通过id更新角色
     *
     * @param roleDto
     * @return
     */
    @Override
    public boolean updateById(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        int result = roleMapper.updateById(role);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 插入角色
     *
     * @param roleDto
     * @return
     */
    @Override
    public boolean save(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        int result = roleMapper.insert(role);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过id删除角色
     *
     * @param roleDto
     * @return
     */
    @Override
    public boolean removeById(RoleDto roleDto) {
        int result = roleMapper.deleteById(roleDto.getId());
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查询角色列表
     *
     * @return
     */
    @Override
    public List<RoleDto> list() {
        List<RoleDto> queryperbyrole = roleMapper.queryperbyrole();
        return queryperbyrole;
    }

    /**
     * 管理角色权限关系
     *
     * @param perRoleVo
     * @return
     */
    @Override
    public boolean managerole(PerRoleVo perRoleVo) {
        // 对前端传输的数据进行分词，得到更新的权限列表
        String str = perRoleVo.getPermissionsList().toString();
        int start = str.indexOf("[");
        int end = str.indexOf("]");
        String[] split = str.substring(start + 1, end).split(", ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        // 删除原有的用户角色关系
        UpdateWrapper<PerRole> wrapper = new UpdateWrapper<>();
        wrapper.eq("rid", perRoleVo.getId());
        perRoleMapper.delete(wrapper);
        // 插入新的角色权限关系，result用于记录插入是否成功
        int result = 0;
        for (Integer integer : list) {
            PerRole perRole = new PerRole();
            perRole.setRid(perRoleVo.getId());
            perRole.setPid(integer);
            perRoleMapper.insert(perRole);
            result++;
        }
        if (result == list.size()) {
            return true;
        } else {
            return false;
        }
    }


}
