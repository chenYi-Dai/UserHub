package com.yichen.userhub.service.impl;

import com.yichen.userhub.config.TxHelper;
import com.yichen.userhub.dao.TUserInfoDao;
import com.yichen.userhub.domain.repo.UserInfoRecordRepo;
import com.yichen.userhub.dto.UserInfoDTO;
import com.yichen.userhub.entity.UserInfoDO;
import com.yichen.userhub.service.UserInfoService;
import com.yichen.userhub.util.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRecordRepo userInfoRecordRepo;

    @Override
    public Long addUserInfo(UserInfoDTO userInfoDto) {
        UserInfoDO userInfoDO = UserInfoDO.builder().build();
        BeanUtils.copyProperties(userInfoDto, userInfoDO);
        Long id = TxHelper.execute(() -> {
            Long add = userInfoRecordRepo.add(userInfoDO, true);
            return add;
        });
        return id;
    }

    @Override
    public UserInfoDO getUserInfoById(Long id) {
        UserInfoDO info = userInfoRecordRepo.getUserInfoById(id, true);
        return info;
    }

    @Override
    public Long updateUserInfo(UserInfoDO userInfoDO) {
        return null;
    }

    @Override
    public Long deleteUserInfoById(Long id) {
        return null;
    }

    @Override
    public UserInfoDO getUserInfoByAccount(UserInfoDO userInfoDO) {
        return null;
    }

    @Override
    public List<UserInfoDO> userInfoList(UserInfoDO userInfoDO) {
        return null;
    }
}
