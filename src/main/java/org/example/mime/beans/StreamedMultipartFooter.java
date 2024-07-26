package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE,
        fieldVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class StreamedMultipartFooter<S extends BodyPartsSummaryAbstract> {

    @JsonProperty("bodyPartsMeta")
    private BodyPartsMeta bodyPartsMeta;

    private S bodyPartsSummary;

    public BodyPartsMeta getBodyPartsMeta() {
        return bodyPartsMeta;
    }

    public void setBodyPartsMeta(BodyPartsMeta bodyPartsMeta) {
        this.bodyPartsMeta = bodyPartsMeta;
    }

    public S getBodyPartsSummary() {
        return bodyPartsSummary;
    }

    public void setBodyPartsSummary(S bodyPartsSummary) {
        this.bodyPartsSummary = bodyPartsSummary;
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder("StreamedMultipartFooter{");
        sb.append("bodyPartsMeta=").append(bodyPartsMeta);
        sb.append(", bodyPartsSummary=").append(bodyPartsSummary);
        sb.append('}');
        return sb.toString();
    }
}