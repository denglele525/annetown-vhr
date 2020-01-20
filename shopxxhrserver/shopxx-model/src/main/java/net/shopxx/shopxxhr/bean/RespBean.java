package net.shopxx.shopxxhr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespBean {
    private int code;
    private String message;
    private Object data;
    private boolean more;

    public RespBean(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RespBean() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public int getCode() {
        return code;
    }

    public RespBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RespBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RespBean setData(Object data) {
        this.data = data;
        return this;
    }

    public boolean isMore() {
        return more;
    }

    public RespBean setMore(boolean more) {
        this.more = more;
        return this;
    }

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ofMessage(int code, String message) {
        return new RespBean(code, message, null);
    }

    public static RespBean ofError(String message) {
        return new RespBean(500, message, null);
    }

    public static RespBean ofSuccess(Object data) {
        return new RespBean(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    public static RespBean ok(String message, Object data) {
        return new RespBean(Status.SUCCESS.getCode(), message, data);
    }

    public static RespBean ofStatus(Status status) {
        return new RespBean(status.getCode(), status.getStandardMessage(), null);
    }

    public static RespBean ok(String message) {
        return new RespBean(Status.SUCCESS.getCode(), message, null);
    }

    public enum Status {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_VALID_PARAM(40005, "Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        NOT_LOGIN(50000, "Not Login");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}