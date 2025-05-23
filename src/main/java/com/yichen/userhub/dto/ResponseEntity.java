package com.yichen.userhub.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.yichen.userhub.util.MdcUtil;
import com.yichen.userhub.util.ReflectionUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Date;

@ApiModel(
        value = "GenericRspDTO",
        description = "通用响应数据传输对象"
)
@Slf4j
@Setter
@Getter
public class ResponseEntity<T> implements Serializable {
    private String traceId = MDC.get(MdcUtil.TRACE_ID);;

    @ApiModelProperty("状态码")
    private int code = 200;

    @ApiModelProperty("返回值消息")
    private String message = "操作成功";
    @ApiModelProperty("返回值")
    private T body;

    @ApiModelProperty("操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp = new Date();

    public static <T> ResponseEntity<T> newInstance(T body) {
        ResponseEntity<T> genericDTO = new ResponseEntity();
        genericDTO.setBody(body);
        return genericDTO;
    }
    public static ResponseEntity<NoBody> newInstance() {
        ResponseEntity<NoBody> genericDTO = new ResponseEntity();
        return genericDTO;
    }

    public static <T extends ResponseEntity<NoBody>, O> T newInstance(Class<T> clazz, O other) {
        T dto = ReflectionUtils.newInstance(clazz);
        if (!ObjectUtils.isEmpty(other)) {
            BeanUtils.copyProperties(dto, other);
        }

        return dto;
    }

    public static <T extends ResponseEntity<NoBody>, O> T newInstance(Class<T> clazz) {
        return newInstance(clazz, (Object)null);
    }
}
