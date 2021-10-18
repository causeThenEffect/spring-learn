package com.szp.pagetest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author songzhipeng
 * @since 2021-10-18
 */
@TableName("user_detail")
@ApiModel(value = "UserDetail对象", description = "")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    private String openid;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("性别 0：未知、1：男、2：女")
    private String sex;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("生日")
    private String birthday;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String area;

    @ApiModelProperty("详细地址")
    private String addressDetail;

    @ApiModelProperty("微信号")
    private String wechatNumber;

    @ApiModelProperty("用户来源于哪个渠道id")
    private Long channelId;

    @ApiModelProperty("评论状态(言论冻结状态) 0-正常 1-冻结中")
    private Integer commentState;

    @ApiModelProperty("安全状态(互动冻结状态）0-正常 1-冻结中")
    private Integer safetyState;

    @ApiModelProperty("注册时间")
    private LocalDateTime registerDate;

    @ApiModelProperty("是否删除")
    private Integer deleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    public Integer getSafetyState() {
        return safetyState;
    }

    public void setSafetyState(Integer safetyState) {
        this.safetyState = safetyState;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
        "id=" + id +
        ", userId=" + userId +
        ", openid=" + openid +
        ", nickname=" + nickname +
        ", email=" + email +
        ", mobile=" + mobile +
        ", sex=" + sex +
        ", avatar=" + avatar +
        ", birthday=" + birthday +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", addressDetail=" + addressDetail +
        ", wechatNumber=" + wechatNumber +
        ", channelId=" + channelId +
        ", commentState=" + commentState +
        ", safetyState=" + safetyState +
        ", registerDate=" + registerDate +
        ", deleted=" + deleted +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}
