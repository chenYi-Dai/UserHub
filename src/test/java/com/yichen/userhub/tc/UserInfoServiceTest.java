package com.yichen.userhub.tc;

import com.alibaba.fastjson.JSONObject;
import com.yichen.userhub.entity.UserInfoDO;
import com.yichen.userhub.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

@Slf4j
public class UserInfoServiceTest extends AbstractTC {

    @Resource
    private UserInfoService userInfoService;

    @Test
    @DisplayName("查询用户角色列表")
    public void testSuccess() throws Exception {
        UserInfoDO infoDO = userInfoService.getUserInfoById(1L);
        log.info("infoDO:{}", JSONObject.toJSONString(infoDO));
    }
}
