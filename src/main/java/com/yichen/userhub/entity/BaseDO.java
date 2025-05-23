package com.yichen.userhub.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDO implements Serializable {
    private String createBy;
    private LocalDateTime createTime;
    private String modifyBy;
    private LocalDateTime modifyTime;

    public BaseDO(String createBy, LocalDateTime createTime, String modifyBy, LocalDateTime modifyTime) {
        this.createBy = createBy;
        this.createTime = createTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
    }

    public BaseDO() {
    }
}
