package com.yichen.userhub.dto.req;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoAddReq {
    private String userAccount;
    private String userName;
    private Integer userStatus;
    private String userEmail;
    private String loginPasswordErrors;
    private String userAddress;
    private String phoneNo;
    private String headPortrait;
    private Integer deleteFlag;
    private String remark;
}
