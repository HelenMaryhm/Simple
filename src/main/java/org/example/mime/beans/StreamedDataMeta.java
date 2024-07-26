package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StreamedDataMeta {

    @JsonProperty("dataCRC")
    private long dataCRC;

    @JsonProperty("contentLength")
    private long contentLength;

    public StreamedDataMeta() {
    }

    public StreamedDataMeta(long dataCRC, long contentLength) {
        this.dataCRC = dataCRC;
        this.contentLength = contentLength;
    }

    public StreamedDataMeta(CrcLengthPair crcLengthPair) {
        this(crcLengthPair.dataCRC(), crcLengthPair.contentLength());
    }

    public long contentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long dataCRC() {
        return dataCRC;
    }

    public void setDataCRC(long dataCRC) {
        this.dataCRC = dataCRC;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StreamedDataMeta{");
        sb.append("contentLength=").append(contentLength);
        sb.append(", dataCRC=").append(dataCRC);
        sb.append('}');
        return sb.toString();
    }
}
