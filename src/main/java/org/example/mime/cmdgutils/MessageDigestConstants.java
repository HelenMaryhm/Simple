package org.example.mime.cmdgutils;

public final class MessageDigestConstants {

    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String MD5 = "MD5";

    public static final String SZ_SHA1_SEED_PREFIX = "v1-Asleep beneath the night sky";
    public static final String SZ_SHA1_SEED_SUFFIX = "we dream the code of innocence";
    public static final String SZ_MD5_SEED_PREFIX = "extra FROSty ice cream camp_fire smoky";
    public static final String SZ_MD5_SEED_SUFFIX = "VESPA YMDB Lustre symlinkHackery JBOD";

    public static final int DIGEST_LENGTH_SHA1 = 20;
    public static final int DIGEST_LENGTH_BLAKE2B = 144;
    public static final int DIGEST_LENGTH_SHA256 = 32;
    public static final int DIGEST_LENGTH_MD5 = 16;

    private MessageDigestConstants() {
        // Constants class
    }
}
