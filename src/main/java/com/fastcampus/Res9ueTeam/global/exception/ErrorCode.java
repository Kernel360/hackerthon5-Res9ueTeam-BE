package com.fastcampus.Res9ueTeam.global.exception;

public enum ErrorCode {
    INVALID_INPUT(400, "잘못된 요청입니다."),
    NOT_FOUND(404, "데이터를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류가 발생했습니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
}
