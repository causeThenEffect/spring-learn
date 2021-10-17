package com.szp.aspectlearn.service;

import com.szp.aspectlearn.annotation.SensitiveListFilter;
import com.szp.aspectlearn.enums.SensitiveFilterTypeEnum;
import org.springframework.stereotype.Service;

/**
 * @Author songzhipeng
 * @DATE 2021/10/17
 */
@Service
public class ArticleListServiceImpl implements ArticleListService {

  @Override
  @SensitiveListFilter(filterType = SensitiveFilterTypeEnum.COMMENT_LIST)
  public String getCommentList() {
    return "comment list";
  }

  @Override
  @SensitiveListFilter(filterType = SensitiveFilterTypeEnum.PULL_LIST)
  public String getPullList() {
    return "pull list";
  }

  @Override
  @SensitiveListFilter(filterType = SensitiveFilterTypeEnum.FRIEND_LIST)
  public String getFriendList() {
    return "friend list";
  }
}
