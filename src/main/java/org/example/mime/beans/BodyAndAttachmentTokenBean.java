package org.example.mime.beans;

public class BodyAndAttachmentTokenBean {
    private String contentType;
    private String content;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toDbString() {
        return content;
    }
}

