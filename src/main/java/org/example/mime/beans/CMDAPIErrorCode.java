package org.example.mime.beans;

/**
 * Error codes specific to CMD APIs
 *
 * @author Deepak on 9/10/18.
 */
@CMDNamespaceErrorCode(ErrorNameSpace.WS)
public enum CMDAPIErrorCode implements InternalErrorCode {

    INVALID_INPUT, RESPONSE_MAPPING_ERROR, INTERNAL_SERVER_ERROR,
    //this the error code returned if the clients are not able to deserialize the errorCode

    SLA_TIMED_OUT_ERROR, REQUEST_LARGER_THAN_ALLOWED_LIMIT, UNKNOWN, FILE_IO_ERROR,
    AUTHORIZATION_FAILED, UNAUTHORIZED
}