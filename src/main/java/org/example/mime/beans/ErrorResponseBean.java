package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Nullable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseBean {
    @Nullable
    private String code;
    @Nullable
    private String message;
    @Nullable
    private List<String> validationErrors;

    public ErrorResponseBean() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public List<String> getValidationErrors() {
        return this.validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("code=").append(this.code);
        sb.append(", ");
        sb.append("message=").append(this.message);
        if (this.validationErrors != null) {
            sb.append(", validationErrors=").append(this.validationErrors.toString());
        }

        sb.append("}");
        return sb.toString();
    }
}

