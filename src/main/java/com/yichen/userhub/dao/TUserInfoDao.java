package com.yichen.userhub.dao;

import com.yichen.userhub.entity.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TUserInfoDao {

    Long addUserInfo(UserInfoDO userInfoDO);

    UserInfoDO getUserInfoById(@Param("id") Long id);

    Long updateUserInfo(UserInfoDO userInfoDO);

    Long deleteUserInfoById(Long id);

    UserInfoDO getUserInfoByAccount(UserInfoDO userInfoDO);

    List<UserInfoDO> userInfoList(UserInfoDO userInfoDO);
}
