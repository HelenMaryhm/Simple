package org.example.mime.beans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotate {@link InternalErrorCode} implementations with this annotation to support error codes which are intended to be returned as an http
 * response from server to client. {@link ErrorNameSpace}
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CMDNamespaceErrorCode {

    /**
     * The {@link ErrorNameSpace} for a given {@code InternalErrorCode} implementation.
     *
     * @return
     */
    ErrorNameSpace value();
}
