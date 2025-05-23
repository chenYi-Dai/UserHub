package com.yichen.userhub.service;

import com.yichen.userhub.dto.UserInfoDTO;
import com.yichen.userhub.entity.UserInfoDO;

import java.util.List;

public interface UserInfoService {

    Long addUserInfo(UserInfoDTO userInfoDO);

    UserInfoDO getUserInfoById(Long id);

    Long updateUserInfo(UserInfoDO userInfoDO);

    Long deleteUserInfoById(Long id);

    UserInfoDO getUserInfoByAccount(UserInfoDO userInfoDO);

    List<UserInfoDO> userInfoList(UserInfoDO userInfoDO);
}
