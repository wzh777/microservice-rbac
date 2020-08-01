package com.bosssoft.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bosssoft.service.UserService;
import com.bosssoft.entity.dto.UserDto;
import com.bosssoft.entity.po.UserPO;
import com.bosssoft.entity.po.UserRolePO;
import com.bosssoft.entity.vo.UserRoleVo;
import com.bosssoft.mapper.UserMapper;
import com.bosssoft.mapper.UserRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 吴志鸿
 * @since 2020-07-25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    /**
     * 通过id修改用户信息
     *
     * @param userDto
     * @return boolean值
     */
    @Override
    public boolean updateById(UserDto userDto) {
        UserPO user = new UserPO();
        BeanUtils.copyProperties(userDto, user);
        int result = userMapper.updateById(user);
        return result == 1;
    }

    /**
     * 插入用户
     *
     * @param userDto
     * @return boolean值
     */
    @Override
    public boolean save(UserDto userDto) {
        UserPO user = new UserPO();
        BeanUtils.copyProperties(userDto, user);
        int result = userMapper.insert(user);
        return result == 1;
    }

    /**
     * 删除用户
     *
     * @param userDto
     * @return boolean值
     */
    @Override
    public boolean removeById(UserDto userDto) {
        int result = userMapper.deleteById(userDto.getId());
        return result == 1;
    }

    /**
     * 查询用户列表
     *
     * @param
     * @return List
     */
    @Override
    public List<UserDto> list() {
        return userMapper.queryperList();
    }

    /**
     * 通过名字查询用户
     *
     * @param userDto
     * @return UserDto
     */
    @Override
    public UserDto getByName(UserDto userDto) {
//        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
//        wrapper.eq("name", userDto.getName());
//        UserPO user = userMapper.selectOne(wrapper);
        UserDto user = userMapper.queryper(userDto.getName());
        if (user != null) {
            user.setResult(true);
        } else {
            user.setResult(false);
        }
        return user;
    }

    /**
     * 登录验证接口
     *
     * @param userDto
     * @return UserDto
     */
    @Override
    public UserDto login(UserDto userDto) {
        UserDto user = userMapper.queryper(userDto.getName());
        UserDto userDto1 = new UserDto();
        if (user != null) {
            BeanUtils.copyProperties(user, userDto1);
            userDto1.setLoginmark(true);
            if (userDto.getPwd().equals(user.getPwd())) {
                userDto1.setToken(UUID.randomUUID().toString());
            } else {
                userDto1.setResult(false);
            }
        } else {
            userDto1.setLoginmark(false);
        }
        return userDto1;
    }

    @Override
    public boolean managerole(UserRoleVo userRoleVo) {
        // 对前端传输的数据进行分词，得到更新的角色列表
        String str = userRoleVo.getRoleList().toString();
        int start = str.indexOf('[');
        int end = str.indexOf(']');
        String[] split = str.substring(start + 1, end).split(", ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        // 删除原有的用户角色关系
        UpdateWrapper<UserRolePO> wrapper = new UpdateWrapper<>();
        wrapper.eq("uid", userRoleVo.getId());
        userRoleMapper.delete(wrapper);
        // 插入新的用户角色关系，result用于记录插入是否成功
        int result = 0;
        for (Integer integer : list) {
            UserRolePO userRole = new UserRolePO();
            userRole.setRid(integer);
            userRole.setUid(userRoleVo.getId());
            userRoleMapper.insert(userRole);
            result++;
        }
        return result == list.size();
    }

}
