package com.yichen.userhub;


import com.yichen.userhub.controller.UserController;
import com.yichen.userhub.dto.GenericDTO;
import com.yichen.userhub.dto.ResponseEntity;
import com.yichen.userhub.dto.UserInfoDTO;
import com.yichen.userhub.dto.UserInfoReq;
import com.yichen.userhub.entity.UserInfoDO;
import com.yichen.userhub.service.UserInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserInfoService userInfoService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserInfoById_Success() {
        // Prepare test data
        UserInfoReq userInfoReq = new UserInfoReq();
        userInfoReq.setId(1L);
        GenericDTO<UserInfoReq> request = new GenericDTO<>();
        request.setBody(userInfoReq);

        UserInfoDO mockUserInfo = UserInfoDO.builder().id("1").build();
        // Set other properties as needed

        // Mock service behavior
        when(userInfoService.getUserInfoById(1L)).thenReturn(mockUserInfo);

        // Execute the method
        ResponseEntity<UserInfoDTO> response = userController.getUserInfoById(request);

        // Verify results
        assertNotNull(response);
        assertEquals(200, response.getCode());
        UserInfoDTO responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(1L, responseBody.getId());
        // Verify other properties as needed

        // Verify service was called
        verify(userInfoService, times(1)).getUserInfoById(1L);
    }

    @Test
    void getUserInfoById_UserNotFound() {
        // Prepare test data
        UserInfoReq userInfoReq = new UserInfoReq();
        userInfoReq.setId(999L);
        GenericDTO<UserInfoReq> request = new GenericDTO<>();
        request.setBody(userInfoReq);

        // Mock service behavior
        when(userInfoService.getUserInfoById(999L)).thenReturn(null);

        // Execute the method
        ResponseEntity<UserInfoDTO> response = userController.getUserInfoById(request);

        // Verify results
        assertNotNull(response);
        assertEquals(200, response.getCode());
        assertNull(response.getBody());

        // Verify service was called
        verify(userInfoService, times(1)).getUserInfoById(999L);
    }

    @Test
    void getUserInfoById_NullRequest() {
        assertThrows(NullPointerException.class, () -> {
            userController.getUserInfoById(null);
        });
    }

    @Test
    void getUserInfoById_NullRequestBody() {
        GenericDTO<UserInfoReq> request = new GenericDTO<>();
        request.setBody(null);

        assertThrows(NullPointerException.class, () -> {
            userController.getUserInfoById(request);
        });
    }

    @Test
    void getUserInfoById_NullUserId() {
        UserInfoReq userInfoReq = new UserInfoReq();
        userInfoReq.setId(null);
        GenericDTO<UserInfoReq> request = new GenericDTO<>();
        request.setBody(userInfoReq);

        assertThrows(NullPointerException.class, () -> {
            userController.getUserInfoById(request);
        });
    }
}