package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SidEntity {

    @JsonProperty("sid")
    private long sid;

    protected SidEntity(long sid) {
        this.sid = sid;
    }

    protected SidEntity() {
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder("SidEntity{");
        sb.append("sid=").append(sid);
        sb.append('}');
        return sb.toString();
    }
}
