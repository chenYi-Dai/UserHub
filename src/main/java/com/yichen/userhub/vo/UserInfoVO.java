package com.yichen.userhub.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ApiModel(value = "UserInfoVO", description = "用户信息")
public class UserInfoVO {
    @ApiModelProperty(value = "主键id")
    private Long id;
    @ApiModelProperty(value = "邮件")
    private String email;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "用户账号")
    private String userAccount;
    @ApiModelProperty(value = "用户密码")
    private String userPwd;
    @ApiModelProperty(value = "用户姓名")
    private String username;
    @ApiModelProperty(value = "用户状态 0：正常 1：冻结")
    private Integer userState;
    @ApiModelProperty(value = "上次登录时间")
    private LocalDateTime lastLoginTime;
    @ApiModelProperty(value = "当前登录时间")
    private LocalDateTime currentLoginTime;
}
