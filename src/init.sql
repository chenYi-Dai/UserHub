CREATE TABLE `t_user_info`
(
    `id`                    bigint(19) unsigned zerofill                                 NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `user_id`               varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编号',
    `user_account`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登陆账号，唯一索引',
    `user_name`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登陆账号，唯一索引',
    `user_state`            char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL COMMENT '用户状态 N:正常 F：冻结\r\nL:锁定\r\nI:初始化(待面签)',
    `user_email`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '邮箱地址',
    `login_password`        varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '登陆密码',
    `login_password_errors` int                                                          NOT NULL COMMENT '登录密码错误次数',
    `user_address`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属用户组属性: 管理员Manager 操作员OPMK 复核员OPCK，与角色表无关',
    `phone_no`              varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
    `head_portrait`         varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '头像',
    `last_login_time`       timestamp                                                    NULL     DEFAULT NULL COMMENT '上次登录时间',
    `current_login_time`    timestamp                                                    NULL     DEFAULT NULL COMMENT '当前登录时间',
    `create_by`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人',
    `create_time`           datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_by`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '修改人',
    `modify_time`           datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `remark`                varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '备注',
    `delete_flag`           varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '是否删除标志：Y-是，N-否',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `unique_user_id` (`user_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000000000000789138
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='用户信息表'