package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nonnull;
import java.nio.charset.StandardCharsets;

public class UnknownCharsetString {

    private String value;
    private byte[] raw;

    @JsonCreator
    public UnknownCharsetString(@Nonnull final String value) {
        this(value, value.getBytes(StandardCharsets.UTF_8));
    }

    public UnknownCharsetString(@Nonnull final String value, @Nonnull final byte[] raw) {
        this.value = value;
        this.raw = raw;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public byte[] getRaw() {
        return raw;
    }

    public void setRaw(byte[] raw) {
        this.raw = raw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final var that = (UnknownCharsetString) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "UnknownCharsetString{" + "value='" + value + '\'' +
                '}';
    }
}
