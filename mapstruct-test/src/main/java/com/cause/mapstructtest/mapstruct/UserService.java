package com.cause.mapstructtest.mapstruct;

import com.cause.mapstructtest.mapper.UserMapper2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cause
 * @date 2022/3/24
 */
@Service
public class UserService {

  @Autowired
  UserMapper2 userMapper;

  public void test1() {

    User user = new User();
//    user.setAge("123");
    user.setId("34534");
    user.setName("sfsdfsdf");

    UserDTO userDTO = userMapper.userMap(user);

    System.out.println(userDTO.getName() + ">>>>>>>>>>>>" + userDTO.getAge());
  }

//  public static void main(String[] args) {
//    UserMapper2 userMapper2 = UserMapper2.INSTANCE;
//
//    User user = User.builder().id(1).name("wrwer").age(234).build();
//
//    UserDTO userDTO = userMapper2.userMap(user);
//
//    System.out.println(userDTO);
//  }

}
