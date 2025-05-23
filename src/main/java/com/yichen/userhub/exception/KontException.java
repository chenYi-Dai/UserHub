package com.yichen.userhub.exception;



import com.yichen.userhub.enums.ErrorCodes;
import org.springframework.util.ObjectUtils;

public class KontException extends RuntimeException {
    private static final long serialVersionUID = 5539431043384054654L;
    public static final String SYS_ERROR_MSGCD;
    private String msgCd;
    private String msgInfo;
    private Throwable cause;
    private boolean businessException = false;
    private boolean mqException = false;

    public KontException(ErrorCodeDict dict) {
        super(dict.getCode() + " : " + dict.getMessage());
        this.msgCd = dict.getCode();
        this.msgInfo = dict.getMessage();
    }

    public KontException(ErrorCodeDict dict, Throwable cause) {
        super(dict.getCode() + " : " + dict.getMessage(), cause);
        this.msgCd = dict.getCode();
        this.msgInfo = dict.getMessage();
        this.cause = cause;
    }

    public KontException(String msgCd, String msgInfo, Throwable cause) {
        super(msgCd + " : " + msgInfo, cause);
        this.msgCd = msgCd;
        this.msgInfo = msgInfo;
        this.cause = cause;
    }

    public KontException(String msgCd, String msgInfo) {
        super(msgCd + " :  " + msgInfo);
        this.msgCd = msgCd;
        this.msgInfo = msgInfo;
    }

    public KontException(String msgCd) {
        super(msgCd);
        this.msgCd = msgCd;
    }

    public KontException(String msgCd, boolean businessException) {
        super(msgCd);
        this.msgCd = msgCd;
        this.businessException = businessException;
    }

    public KontException(Throwable cause) {
        super(SYS_ERROR_MSGCD, cause);
        this.cause = cause;
        this.msgCd = SYS_ERROR_MSGCD;
    }

    public KontException(String msgInfo, Throwable cause) {
        super(SYS_ERROR_MSGCD + " : " + msgInfo);
        this.msgCd = SYS_ERROR_MSGCD;
        this.msgInfo = msgInfo;
        this.cause = cause;
    }

    public KontException() {
        super(SYS_ERROR_MSGCD);
        this.msgCd = SYS_ERROR_MSGCD;
    }

    public static void throwBusinessException(String msgCd) {
        throw new KontException(msgCd, true);
    }

    public static void throwKontException() {
        throw new KontException();
    }

    public static void throwKontException(String msgCd) {
        throw new KontException(msgCd);
    }

    public static void throwKontException(Throwable t) {
        if (t instanceof KontException) {
            throw (KontException)t;
        } else {
            throw new KontException(t);
        }
    }

    public static void throwKontException(String msgInfo, Throwable t) {
        throw new KontException(msgInfo, t);
    }

    public static void throwKontException(String msgCd, String msgInfo) {
        throw new KontException(msgCd, msgInfo);
    }

    public static void throwKontException(String msgCd, String msgInfo, boolean isMqException) {
        KontException kontException = new KontException(msgCd, msgInfo);
        kontException.setMqException(true);
        throw kontException;
    }

    public static void throwKontException(String msgCd, String msgInfo, Throwable throwable) {
        throw new KontException(msgCd, msgInfo, throwable);
    }

    public static void throwKontException(ErrorCodeDict codeDict) {
        throw new KontException(codeDict.getCode(), codeDict.getMessage());
    }

    public static void throwKontException(ErrorCodeDict codeDict, Throwable throwable) {
        throw new KontException(codeDict.getCode(), codeDict.getMessage(), throwable);
    }

    public static KontException create(Throwable t) {
        return isKontException(t) ? (KontException)t : new KontException(t);
    }

    public static KontException create(String msgCd) {
        return new KontException(msgCd);
    }

    public static KontException create(String msgCd, String msgInfo) {
        return new KontException(msgCd, msgInfo);
    }

    public static boolean isKontException(Throwable throwable) {
        return !ObjectUtils.isEmpty(throwable) && throwable instanceof KontException;
    }

    public String getMsgCd() {
        return this.msgCd;
    }

    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    public String getMsgInfo() {
        return this.msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public boolean isBusinessException() {
        return this.businessException;
    }

    public boolean isMqException() {
        return this.mqException;
    }

    public void setMqException(boolean mqException) {
        this.mqException = mqException;
    }

    public void setBusinessException(boolean businessException) {
        this.businessException = businessException;
    }

    static {
        SYS_ERROR_MSGCD = ErrorCodes.EOUTGW001.getCode();
    }
}
