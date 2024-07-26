package org.example.mime.beans;

public interface CrcLengthPair {

    /**
     * crc of data
     *
     * @return long value
     */
    long dataCRC();

    /**
     * length of data in bytes
     *
     * @return long value
     */
    long contentLength();
}

