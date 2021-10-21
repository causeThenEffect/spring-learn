package com.szp.pagetest.controller;


import com.szp.web.plus.base.BaseController;
import com.szp.web.plus.resp.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songzhipeng
 * @since 2021-10-18
 */
@RestController
@RequestMapping("/pagetest/userDetail")
public class UserDetailController extends BaseController {

  @GetMapping("/getUserInfo")
  public RestResponse<String> getUserInfo() {
    return rest(() -> "hshshhh");
  }

}

