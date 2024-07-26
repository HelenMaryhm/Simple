package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class SidEntityBatch<S> extends SidEntity {

    @JsonIgnore
    private final ApiStatus emptyBatchStatus;

    @JsonProperty("succeeded")
    private List<S> successEntities = List.of();

    @JsonProperty("failed")
    private List<CMDErrorResponseBean> failedReqs = List.of();

    protected SidEntityBatch(ApiStatus emptyBatchStatus) {
        this.emptyBatchStatus = emptyBatchStatus;
    }

    protected SidEntityBatch(long sid, @Nonnull ApiStatus emptyBatchStatus, @Nonnull List<S> successEntities,
                             @Nonnull List<CMDErrorResponseBean> failedReqs) {
        super(sid);
        this.emptyBatchStatus = emptyBatchStatus;
        this.successEntities = successEntities;
        this.failedReqs = failedReqs;
    }

    public List<S> getSuccessEntities() {
        return successEntities;
    }

    public void setSuccessEntities(List<S> successEntities) {
        this.successEntities = successEntities;
    }

    public List<CMDErrorResponseBean> getFailedReqs() {
        return failedReqs;
    }

    public void setFailedReqs(List<CMDErrorResponseBean> failedReqs) {
        this.failedReqs = failedReqs;
    }

    @JsonGetter("status")
    public ApiStatus getStatus() {
        if (getBatchSize() == 0) {
            return emptyBatchStatus;
        } else if (successEntities.isEmpty()) {
            return ApiStatus.FAILURE;
        } else {
            return failedReqs.isEmpty() ? ApiStatus.SUCCESS : ApiStatus.PARTIAL;
        }
    }

    @JsonIgnore
    public int getBatchSize() {
        return successEntities.size() + failedReqs.size();
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder("SidEntityBatch{");
        sb.append("successEntities=").append(successEntities);
        sb.append(", failedReqs=").append(failedReqs);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
