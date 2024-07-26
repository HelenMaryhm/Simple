package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class CMDErrorResponseBean extends ErrorResponseBean {
    @JsonProperty("requestKey")
    //key of the requests as sent by the client
    private String reqKey;
    @JsonProperty("httpStatusCode")
    private int httpStatusCode;
    @JsonProperty("appErrorCode")
    private AppErrorCode appErrorCode;
    @JsonProperty("internalErrorCode")
    private InternalErrorCode internalErrorCode;
    @JsonProperty("errorDescription")
    //error description
    private String errorDescription;

    public String getReqKey() {
        return reqKey;
    }

    public void setReqKey(String reqKey) {
        this.reqKey = reqKey;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public AppErrorCode getAppErrorCode() {
        return appErrorCode;
    }

    public void setAppErrorCode(AppErrorCode appErrorCode) {
        this.appErrorCode = appErrorCode;
    }

    public InternalErrorCode getInternalErrorCode() {
        return internalErrorCode;
    }

    public void setInternalErrorCode(InternalErrorCode internalErrorCode) {
        this.internalErrorCode = internalErrorCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CMDErrorResponse{");
        sb.append("reqKey='").append(reqKey).append('\'');
        sb.append(", errorDescription='").append(errorDescription).append('\'');
        sb.append(", httpStatusCode=").append(httpStatusCode);
        sb.append(", appErrorCode='").append(appErrorCode).append('\'');
        sb.append(", internalErrorCode=").append(internalErrorCode);
        sb.append('}');
        return sb.toString();
    }
}

