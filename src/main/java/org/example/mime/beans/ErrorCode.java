package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ErrorCode extends EnumTypeBase {

    /**
     * string representation of error code
     *
     * @return
     */
    @JsonValue
    default String getErrorMessage() {
        return name();
    }
}
