package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageStructurePart {
    // All MIME headers for the current part
    @JsonProperty("parsedMimeHeaders")
    private Map<String, List<UnknownCharsetString>> parsedMimeHeaders;

    //Sub-parts structure of the current part, if the current part is not RFC822, docTree will be null
    @JsonProperty("docTree")
    private MessageStructurePart docTree;

    // Multipart map, if the current part is not a multipart, or it's a RFC822 part, parts will be null
    @JsonProperty("parts")
    private Map<String, MessageStructurePart> parts;

    // attachment hash id, only exists for detached part
    @JsonProperty("oid")
    private String oid;

    @JsonProperty("size")
    //size of the current MIME part
    private Integer size;

    @JsonProperty("sha256")
    private String sha256;

    //RFC822 Headers, if the current part is not RFC822, parsedRFC822Headers will be null
    @JsonProperty("parsedRFC822Headers")
    private Map<String, List<UnknownCharsetString>> parsedRFC822Headers;

    @JsonProperty("pid")
    //ID of the current MIME part
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public MessageStructurePart getDocTree() {
        return docTree;
    }

    public void setDocTree(MessageStructurePart docTree) {
        this.docTree = docTree;
    }

    public Map<String, List<UnknownCharsetString>> getParsedRFC822Headers() {
        return parsedRFC822Headers;
    }

    public void setParsedRFC822Headers(Map<String, List<UnknownCharsetString>> parsedRFC822Headers) {
        this.parsedRFC822Headers = parsedRFC822Headers;
    }

    public Map<String, MessageStructurePart> getParts() {
        return parts;
    }

    public void setParts(Map<String, MessageStructurePart> parts) {
        this.parts = parts;
    }

    public Map<String, List<UnknownCharsetString>> getParsedMimeHeaders() {
        return parsedMimeHeaders;
    }

    public void setParsedMimeHeaders(Map<String, List<UnknownCharsetString>> parsedMimeHeaders) {
        this.parsedMimeHeaders = parsedMimeHeaders;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "MessageStructurePart{" + "pid='" + pid + '\'' +
                ", size=" + size +
                ", sha256='" + sha256 + '\'' +
                ", docTree='" + docTree + '\'' +
                ", parsedRFC822Headers='" + parsedRFC822Headers + '\'' +
                ", parts='" + parts + '\'' +
                ", parsedMimeHeaders='" + parsedMimeHeaders + '\'' +
                ", oid='" + oid + '\'' +
                ", " + super.toString() +
                '}';
    }
}
