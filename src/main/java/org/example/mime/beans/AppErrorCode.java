package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.http.HttpStatus;

import javax.annotation.Nonnull;
import java.util.Map;

public enum AppErrorCode {
    AUTHORIZATION_FAILED(HttpStatus.SC_UNAUTHORIZED), UNAUTHORIZED(HttpStatus.SC_FORBIDDEN), MAILBOX_INACTIVE(HttpStatus.SC_FORBIDDEN), MAILBOX_DEACTIVATED(HttpStatus.SC_FORBIDDEN),
    RESOURCE_NOT_FOUND(HttpStatus.SC_NOT_FOUND), INVALID_INPUT(HttpStatus.SC_BAD_REQUEST), NO_OP(HttpStatus.SC_BAD_REQUEST),
    CONFLICT(HttpStatus.SC_CONFLICT), PROCESSING_ERROR(HttpStatus.SC_INTERNAL_SERVER_ERROR), RATE_LIMITED(429),
    REQUEST_TOO_LONG(HttpStatus.SC_REQUEST_TOO_LONG), MESSAGE_NOT_FOUND(HttpStatus.SC_NOT_FOUND), MAILBOX_NOT_FOUND(HttpStatus.SC_NOT_FOUND),
    MESSAGE_ALREADY_PURGED(HttpStatus.SC_BAD_REQUEST), MESSAGE_DELETE_FAILED(HttpStatus.SC_BAD_REQUEST),
    INVALID_TARGET_FOLDER_ID(HttpStatus.SC_BAD_REQUEST), PURGE_TS_VALIDATION_FAILED(HttpStatus.SC_BAD_REQUEST), TNEF_RESOURCE_NOT_FOUND(HttpStatus.SC_NOT_FOUND);

    private static final Map<String, AppErrorCode> nameToEnum = CommonUtils.mapEnum(AppErrorCode.class, AppErrorCode::name);
    private final int httpStatus;

    AppErrorCode(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    @JsonCreator
    public static AppErrorCode fromString(@Nonnull String str) {
        //Using PROCESSING_ERROR for default for transition from old to new error response
        return nameToEnum.getOrDefault(str, AppErrorCode.PROCESSING_ERROR);
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
