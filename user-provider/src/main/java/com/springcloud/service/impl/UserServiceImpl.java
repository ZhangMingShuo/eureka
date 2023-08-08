package com.springcloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.springcloud.pojo.AppUser;
import com.springcloud.service.UserService;
import com.springcloud.user.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public AppUser getUser(String userId) {
        AppUser user = new AppUser();
        user.setUserid(userId);

        List<AppUser> userList = appUserMapper.select(user);
        return userList.get(0);
    }

    @Override
    public List<AppUser> getAllUser(Integer page, Integer pageSize) {
        Example example = new Example(AppUser.class);
        example.orderBy("createdTime").desc();
        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("userid","");

        PageHelper.startPage(page, pageSize);
        List<AppUser> userList = appUserMapper.selectByExample(example);
        return userList;
    }
}
