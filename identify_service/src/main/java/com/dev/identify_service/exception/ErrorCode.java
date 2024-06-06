package com.dev.identify_service.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    USER_NOT_FOUND(404, "User Not Found!"),
    UNCATERRIZED_EXCEPTION(9999, "Uncaterrized Error"),
    INVALID_KEY(1111, "Invalid key"),
    USER_EXISTED(1001, "User already exists!"),
    USERNAME_INVALID(1002, "Username must be min 3 and max 20 characters!"),
    PASSWORD_INVALID(1003, "Password must be min 8 and max 20 characters!");

    int code;
    String message;
}
