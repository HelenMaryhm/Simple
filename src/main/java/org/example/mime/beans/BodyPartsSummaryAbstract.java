package org.example.mime.beans;


import javax.annotation.Nonnull;

public abstract class BodyPartsSummaryAbstract extends SidEntityBatch<String> {

    protected BodyPartsSummaryAbstract(@Nonnull ApiStatus emptyBatchStatus) {
        super(emptyBatchStatus);
    }
}

