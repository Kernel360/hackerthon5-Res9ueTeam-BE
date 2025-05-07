package com.fastcampus.Res9ueTeam.global.exception;

public class ErrorResponse {
    private final int status;
    private final String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(ErrorCode code) {
        return new ErrorResponse(code.getStatus(), code.getMessage());
    }

    // getter 생략 or Lombok @Getter 사용 가능
}
