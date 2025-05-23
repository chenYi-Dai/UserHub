package com.yichen.userhub.domain.repo;

import com.yichen.userhub.dao.TUserInfoDao;
import com.yichen.userhub.entity.UserInfoDO;
import com.yichen.userhub.enums.ErrorCodes;
import com.yichen.userhub.enums.ExpType;
import com.yichen.userhub.exception.ErrorCodeDict;
import com.yichen.userhub.exception.KontException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserInfoRecordRepo {

    @Resource
    private TUserInfoDao userInfoDao;


    public Long add(UserInfoDO userInfoDO,boolean isTx) {
        Long row = userInfoDao.addUserInfo(userInfoDO);
        if (isTx && row != 1) {
            throw new KontException(ErrorCodes.EOUTGW001.getCode(), ErrorCodes.EOUTGW001.getMessage());
        }
        return userInfoDO.getId();
    }

    public UserInfoDO getUserInfoById(Long id,boolean isTx) {
        UserInfoDO info = userInfoDao.getUserInfoById(id);
        if (isTx && info == null) {
            throw new KontException(ErrorCodes.EOUTGW001.getCode(), ErrorCodes.EOUTGW001.getMessage());
        }
        if(!isTx && info == null){
            return null;
        }
        return info;
    }
}
