package org.example.mime.beans;

import javax.annotation.Nonnull;
import java.util.List;

public class SearchData {
    private List<BodyAndAttachmentTokenBean> body;
    private List<BodyAndAttachmentTokenBean> attachments;

    public List<BodyAndAttachmentTokenBean> getBody() {
        return body;
    }

    public void setBody(@Nonnull final List<BodyAndAttachmentTokenBean> body) {
        this.body = body;
    }

    public List<BodyAndAttachmentTokenBean> getAttachments() {
        return attachments;
    }

    public void setAttachments(@Nonnull final List<BodyAndAttachmentTokenBean> attachments) {
        this.attachments = attachments;
    }

    public String toBodyTokensDbString() {
        final StringBuilder sb = new StringBuilder();
        if (body != null) {
            for (BodyAndAttachmentTokenBean token : body) {
                sb.append(token.toDbString()).append(" ");
            }
        }
        return sb.toString();
    }

    public String toAttachmentsTokensDbString() {
        final StringBuilder sb = new StringBuilder();
        if (attachments != null) {
            for (BodyAndAttachmentTokenBean token : attachments) {
                sb.append(token.toDbString()).append(" ");
            }
        }
        return sb.toString();
    }
}
