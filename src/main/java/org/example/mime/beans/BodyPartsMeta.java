package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class BodyPartsMeta {

    //Map for http part name and StreamedDataMeta Footer for the HTTP Part.
    private final Map<String, StreamedDataMeta> streamedDataMeta;

    public BodyPartsMeta(@JsonProperty("streamedDataMeta") Map<String, StreamedDataMeta> streamedDataMeta) {
        this.streamedDataMeta = streamedDataMeta;
    }

    public Map<String, StreamedDataMeta> getStreamedDataMeta() {
        return streamedDataMeta;
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder("BodyPartsMeta{");
        sb.append("streamedDataMeta=").append(streamedDataMeta);
        sb.append('}');
        return sb.toString();
    }
}
