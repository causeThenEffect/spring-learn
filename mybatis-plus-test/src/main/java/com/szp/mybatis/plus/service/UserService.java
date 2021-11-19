package com.szp.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szp.mybatis.plus.mapper.UserDetailMapper;
import com.szp.mybatis.plus.model.UserDetail;
import org.springframework.stereotype.Service;

/**
 * @author cause
 * @date 2021/11/18
 */
@Service
public class UserService extends ServiceImpl<UserDetailMapper, UserDetail> {

}
