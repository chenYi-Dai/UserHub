package com.yichen.userhub.controller;


import com.yichen.userhub.dto.GenericDTO;
import com.yichen.userhub.dto.ResponseEntity;
import com.yichen.userhub.dto.UserInfoDTO;
import com.yichen.userhub.dto.UserInfoReq;
import com.yichen.userhub.entity.UserInfoDO;
import com.yichen.userhub.service.UserInfoService;
import com.yichen.userhub.util.BeanUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;


    @PostMapping("/getUserInfoById")
    @ApiOperation(value = "查询用户角色列表", notes = "getUserInfoById")
    @ApiResponse(code = 200, message = "查询用户信息")
    public ResponseEntity<UserInfoDTO> getUserInfoById(@RequestBody GenericDTO<UserInfoReq> userInfoReq) {
        UserInfoReq body = userInfoReq.getBody();
        UserInfoDO userInfoDO = userInfoService.getUserInfoById(body.getId());
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfoDO, userInfoDTO);
        return ResponseEntity.newInstance(userInfoDTO);
    }
}
