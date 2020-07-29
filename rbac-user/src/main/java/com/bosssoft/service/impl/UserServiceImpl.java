package com.bosssoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bosssoft.dto.UserDto;
import com.bosssoft.mapper.PerRoleMapper;
import com.bosssoft.mapper.UserRoleMapper;
import com.bosssoft.po.User;
import com.bosssoft.mapper.UserMapper;
import com.bosssoft.po.UserRole;
import com.bosssoft.service.UserService;
import com.bosssoft.vo.UserRoleVO.UserRoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PerRoleMapper perRoleMapper;


    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public boolean updateById(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        int result = userMapper.updateById(user);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        int result = userMapper.insert(user);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeById(UserDto userDto) {
        int result = userMapper.deleteById(userDto.getId());
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<UserDto> list() {
        List<UserDto> userDtos = userMapper.queryperList();
        return userDtos;
    }

    @Override
    public UserDto getByName(UserDto userDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", userDto.getName());
        User user = userMapper.selectOne(wrapper);
        if (user != null) {
            BeanUtils.copyProperties(user, userDto);
            userDto.setResult(true);
        } else {
            userDto.setResult(false);
        }
        return userDto;
    }

    @Override
    public UserDto login(UserDto userDto) {
        UserDto user = userMapper.queryper(userDto.getName());
        UserDto userDto1 = new UserDto();
        if (user != null) {
            BeanUtils.copyProperties(user, userDto1);
            userDto1.setLoginmark(true);
            if (userDto.getPwd().equals(user.getPwd())) {
                userDto1.setResult(true);
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
        String str = userRoleVo.getRoleList().toString();
        int start = str.indexOf("[");
        int end = str.indexOf("]");

        String[] split = str.substring(start + 1, end).split(", ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        UpdateWrapper<UserRole> wrapper = new UpdateWrapper<>();
        wrapper.eq("uid", userRoleVo.getId());
        userRoleMapper.delete(wrapper);

        int result = 0;
        for (Integer integer : list) {
            UserRole userRole = new UserRole();
            userRole.setRid(integer);
            userRole.setUid(userRoleVo.getId());
            userRoleMapper.insert(userRole);
            result++;
        }
        if (result == list.size()) {
            return true;
        } else {
            return false;
        }

    }



}
