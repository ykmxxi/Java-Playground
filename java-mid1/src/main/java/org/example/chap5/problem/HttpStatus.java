package org.example.chap5.problem;

public enum HttpStatus {

    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public static HttpStatus findByCode(final int httpCodeInput) {
        for (HttpStatus status : values()) {
            if (status.code == httpCodeInput) {
                return status;
            }
        }
        return null;
    }

    public boolean isSuccess() {
        return this.code >= 200 && this.code < 300;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
