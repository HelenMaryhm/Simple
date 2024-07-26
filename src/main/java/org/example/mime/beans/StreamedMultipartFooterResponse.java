package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamedMultipartFooterResponse extends StreamedMultipartFooter<BodyPartsSummaryResponse> {
    @JsonProperty("responseSummary")
    @Override
    public BodyPartsSummaryResponse getBodyPartsSummary() {
        return super.getBodyPartsSummary();
    }

    @JsonProperty("responseSummary")
    @Override
    public void setBodyPartsSummary(BodyPartsSummaryResponse bodyPartsSummary) {
        super.setBodyPartsSummary(bodyPartsSummary);
    }
}
