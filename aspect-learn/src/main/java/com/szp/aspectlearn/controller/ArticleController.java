package com.szp.aspectlearn.controller;

import com.szp.aspectlearn.service.ArticleListService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author songzhipeng
 * @DATE 2021/10/17
 */
@RestController
public class ArticleController {

  @Resource
  ArticleListService articleListService;

  @GetMapping(value = "/getCommentList")
  public String getCommentList() {
    return articleListService.getCommentList();
  }

  @GetMapping(value = "/getPullList")
  public String getPullList() {
    return articleListService.getPullList();
  }

  @GetMapping(value = "/getFriendList")
  public String getFriendList() {
    return articleListService.getFriendList();
  }

}
