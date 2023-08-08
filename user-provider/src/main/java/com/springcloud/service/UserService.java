package com.springcloud.service;

import com.springcloud.pojo.AppUser;

import java.util.List;

public interface UserService {
    /**
     * 根据用户id查询用户信息
     */
    public AppUser getUser(String userId);
    /**
     * 查询所有用户信息，可实现分页
     */
    public List<AppUser> getAllUser(Integer page, Integer pageSize);
}

