package com.hanhan.test1.services;

import com.hanhan.test1.dao.mapperJava1.*;
import com.hanhan.test1.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/10/8.
 */

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ModuleRoleMapper moduleRoleMapper;
    @Autowired
    private ModuleMapper moduleMapper;

    public User findUserByUserName(String username){
        User user = userMapper.findUserByUserName(username);
        if(user==null){return null;}
        UserRoleExample userRoleExample=new UserRoleExample();
        userRoleExample.createCriteria().andUidEqualTo(user.getUid());
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
        if(null!=userRoles){
            Set<Role>roles=new LinkedHashSet<Role>();
            for(UserRole userRole:userRoles){
                Role role = roleMapper.selectByPrimaryKey(userRole.getRid());
                if(null!=role){
                    ModuleRoleExample moduleRoleExample=new ModuleRoleExample();
                    moduleRoleExample.createCriteria().andRidEqualTo(role.getRid());
                    List<ModuleRole> moduleRoles = moduleRoleMapper.selectByExample(moduleRoleExample);
                    if(moduleRoles!=null){
                        Set<Module>modules=new LinkedHashSet<Module>();
                        for(ModuleRole moduleRole:moduleRoles){
                            Module module = moduleMapper.selectByPrimaryKey(moduleRole.getMid());
                            if(module!=null){
                                modules.add(module);
                            }
                        }
                        role.setModules(modules);
                    }
                    roles.add(role);
                }
            }
            user.setRoles(roles);
        }
        return user;
    }




}
