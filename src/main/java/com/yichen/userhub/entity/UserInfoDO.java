package com.yichen.userhub.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class UserInfoDO extends BaseDO {
    private Long id;
    private String userId;
    private String userAccount;
    private String userName;
    private Integer userStatus;
    private String userEmail;
    private String loginPassword;
    private String loginPasswordErrors;
    private String userAddress;
    private String phoneNo;
    private String headPortrait;
    private LocalDateTime lastLoginTime;
    private LocalDateTime currentLoginTime;
    private Integer deleteFlag;
    private String remark;
}
