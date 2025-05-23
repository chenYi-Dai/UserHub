package com.yichen.userhub.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private String id;
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
    private String remark;private String createBy;
    private LocalDateTime createTime;
    private String modifyBy;
    private LocalDateTime modifyTime;

}
