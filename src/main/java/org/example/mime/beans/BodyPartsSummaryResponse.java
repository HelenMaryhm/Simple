package org.example.mime.beans;

public class BodyPartsSummaryResponse extends BodyPartsSummaryAbstract {

    public BodyPartsSummaryResponse() {
        super(ApiStatus.SUCCESS);
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder("BodyPartsSummaryResponse{");
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
