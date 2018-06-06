package org.zhongweixian.exception;

import java.text.MessageFormat;

/**
 * 自定义的错误码
 */
public enum ErrorCode {

    XML_PARSE_ERROR(10001 , "XML解析异常:{0}"),
    PAY_RESPONSE_NULL(20001, "{0}-{1}支付接口返回为空"),
    PAY_RESPONSE_ERROR(20002, "支付失败:{0}"),
    PAY_CHANNEL_ERROR(30001, "支付平台不存在:{0}"),
    PAY_TYPE_ERROR(30002, "支付类型不存在:{0}");


    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(Object... param) {
        if (param.length == 0) {
            return message;
        }
        return MessageFormat.format(message, param);
    }

    public static ErrorCode getByCode(int code) {
        ErrorCode[] values = ErrorCode.values();
        for (ErrorCode value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }
}
