package com.yichen.userhub.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import com.yichen.userhub.util.JudgeUtils;
import com.yichen.userhub.util.ReflectionUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

/**
 * 通用数据传输对象
 *
 * @author ZHANG YI FA
 * @date 2019-06-24
 */
@ApiModel(value = "GenericDTO", description = "通用数据传输对象")
@ToString
public class GenericDTO<T> implements Serializable {

    /**
     * 业务流水号，全链路透传
     */
    @ApiModelProperty(hidden = true)
    private String bizId;

    /** 调用链Span唯一标识 */
    @ApiModelProperty(hidden = true)
    private String spanId;

    /**
     * 登录用户ID
     */
    @ApiModelProperty(hidden = true)
    private String userId;

    @ApiModelProperty(name="source", value="来源模块编码", hidden = true)
    private String source;

    @ApiModelProperty(name="channel", value="渠道", hidden = true)
    private String channel;

    @ApiModelProperty(hidden = true)
    @Deprecated
    private String business;

    @ApiModelProperty(hidden = true)
    private String uri;

    @ApiModelProperty(hidden = true)
    @Deprecated
    private String token;

    @ApiModelProperty(hidden = true)
    private String loginName;

    /**
     * 服务ID
     */
    @ApiModelProperty(hidden = true)
    private String serviceId;

    /**
     *  顺序号 - 用于表示当前交易在整个服务调用链中的顺序
     */
    @ApiModelProperty(hidden = true)
    private Integer seq;


    @ApiModelProperty(value = "业务传输对象; 非嵌套业务传输对象，忽略该属性")
    private T body;


    public static <T> GenericDTO<T> newInstance(T body) {
        GenericDTO<T> genericDTO = new GenericDTO<>();
        genericDTO.setBody(body);
        return genericDTO;
    }


    public static GenericDTO<NoBody> newInstance() {
        GenericDTO<NoBody> genericDTO = new GenericDTO<>();
        return genericDTO;
    }


    public static <T extends GenericDTO<NoBody>, O> T newInstance(Class<T> clazz, O other) {
        T dto = ReflectionUtils.newInstance(clazz);
        if (JudgeUtils.isNotNull(other)) {
            BeanUtils.copyProperties(dto, other);
        }
        return dto;
    }


    public static <T extends GenericDTO<NoBody>, O> T newInstance(Class<T> clazz) {
        return newInstance(clazz, null);
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }


}
