package com.bosssoft;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.bosssoft.dto.PermissionsDto;
import com.bosssoft.dto.UserDto;
import com.bosssoft.mapper.PerRoleMapper;
import com.bosssoft.mapper.UserMapper;
import com.bosssoft.mapper.UserRoleMapper;
import com.bosssoft.po.User;
import com.bosssoft.po.UserRole;
import com.bosssoft.service.UserService;
import com.bosssoft.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RbacUserApplicationTests {

        @Autowired
        UserService userService;
        @Autowired
        UserMapper userMapper;

        @Autowired
        PerRoleMapper perRoleMapper;

        @Autowired
        UserRoleMapper userRoleMapper;

        @Test
        void contextLoads() {
                User user = userMapper.selectById(1);
                System.out.println(user);
        }


        @Test
        void query(){
                UpdateWrapper<UserRole> wrapper = new UpdateWrapper<>();
                wrapper.eq("uid",1);
                userRoleMapper.delete(wrapper);
        }
}
