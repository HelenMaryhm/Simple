package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public interface InternalErrorCode extends ErrorCode {

    @JsonCreator
    static InternalErrorCode fromGlobalName(String error) {
        InternalErrorCode code = ErrorNameSpace.fromErrorMessage(error);
        return code == null ? CMDAPIErrorCode.UNKNOWN : code;
    }

    static Set<InternalErrorCode> getAllCodes() {
        return ErrorNameSpace.getAllCodes();
    }

    /**
     * defines the {@link ErrorNameSpace} which groups error code instances of a given implementation of {@link InternalErrorCode}
     *
     * @return
     */
    default ErrorNameSpace getErrorNameSpace() {
        return getClass().getAnnotation(CMDNamespaceErrorCode.class).value();
    }
}
