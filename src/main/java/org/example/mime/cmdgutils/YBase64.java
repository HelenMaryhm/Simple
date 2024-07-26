package org.example.mime.cmdgutils;

import javax.annotation.Nonnull;

public final class YBase64 {
    private static final char PADCHAR_BASE64 = '=';
    private static final char PADCHAR_Y64 = '-';
    private static final char[] forward_bytecode_base64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', // 0 - 12
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', // 13 - 25
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', // 26 - 38
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', // 39 - 51
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'       // 52 - 63
    };
    private static final char[] forward_bytecode_y64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', // 0 - 12
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', // 13 - 25
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', // 26 - 38
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', // 39 - 51
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '_'       // 52 - 63
    };
    private static final byte[] reverse_bytecode_base64 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 0-15
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 16-31
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, // 32-47
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, // 48-63
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, // 64-79
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, // 80-95
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, // 96-111
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, // 112-127
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 128-143
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 144-159
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 160-175
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 176-191
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 192-207
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 208-223
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 224-239
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1  // 240-255
    };
    private static final byte[] reverse_bytecode_y64 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 0-15
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 16-31
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, // 32-47
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, // 48-63
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, // 64-79
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, // 80-95
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, // 96-111
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, // 112-127
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 128-143
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 144-159
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 160-175
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 176-191
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 192-207
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 208-223
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, // 224-239
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1  // 240-255
    };

    private YBase64() {
        //Utility class
    }

    /**
     * Decode a base64 string into bytes
     *
     * @param data The input base64 string
     * @param y64  use y64 decoding
     * @return A byte array containing the decoded bytes
     */
    @Nonnull
    public static byte[] decode(String data, boolean y64) {
        char padchar = y64 ? PADCHAR_Y64 : PADCHAR_BASE64;
        byte[] reverseBytecode = y64 ? reverse_bytecode_y64 : reverse_bytecode_base64;

        int inlen = data.length();
        byte[] encobj = new byte[ 4 ];
        int quantum = inlen / 4;
        if (inlen % 4 > 0) {
            quantum++;
        }
        int outlen = quantum * 3;
        for (int t = 1; t < 4; t++) {
            if (data.charAt(inlen - t) == padchar) {
                outlen--;
            }
        }
        byte[] outobj = new byte[ outlen ];

        for (int i = 0; i < quantum; i++) {
            for (int t = 0; t < 4; t++) {
                encobj[ t ] = (i * 4 + t < inlen) ? reverseBytecode[ data.charAt(i * 4 + t) ] : 0;
            }
            int offsetBase = i * 3;
            if (offsetBase < outlen) {
                outobj[ offsetBase ] = (byte) ((encobj[ 0 ] << 2) + ((encobj[ 1 ] & 0x30) >> 4));
            }
            if (offsetBase + 1 < outlen) {
                outobj[ offsetBase + 1 ] = (byte) (((encobj[ 1 ] & 0x0f) << 4) + ((encobj[ 2 ] & 0x3c) >> 2));
            }
            if (offsetBase + 2 < outlen) {
                outobj[ offsetBase + 2 ] = (byte) (((encobj[ 2 ] & 0x03) << 6) + (encobj[ 3 ] & 0x3f));
            }
        }

        return outobj;
    }

    /**
     * Encode bytes into a base64 string
     *
     * @param data the input data to encode as a byte array
     * @param y64  use y64 encoding
     * @return a base64 string of the data
     */
    public static String encode(byte[] data, boolean y64) {
        return encode(data, 0, data.length, y64);
    }

    public static String encode(byte[] data, int offset, int length, boolean y64) {
        char padchar = y64 ? PADCHAR_Y64 : PADCHAR_BASE64;
        char[] forwardBytecode = y64 ? forward_bytecode_y64 : forward_bytecode_base64;

        int i;

        int quantum = length / 3;
        if (length % 3 > 0) {
            quantum++;
        }

        char[] out = new char[ quantum * 4 ];

        for (i = 0; i < quantum; i++) {
            out[ (i * 4) ] = forwardBytecode[ (data[ (i * 3) + offset ] & 0xfc) >> 2 ];
            if (length == (i * 3) + 1) {
                out[ (i * 4) + 1 ] = forwardBytecode[ ((data[ (i * 3) + offset ] & 0x03) << 4) ];
                out[ (i * 4) + 2 ] = padchar;
                out[ (i * 4) + 3 ] = padchar;
            } else if (length == (i * 3) + 2) {
                out[ (i * 4) + 1 ] = forwardBytecode[ ((data[ (i * 3) + offset ] & 0x03) << 4) + ((data[ (i * 3) + 1 + offset ] & 0xf0) >> 4) ];
                out[ (i * 4) + 2 ] = forwardBytecode[ ((data[ (i * 3) + 1 + offset ] & 0x0f) << 2) ];
                out[ (i * 4) + 3 ] = padchar;
            } else {
                out[ (i * 4) + 1 ] = forwardBytecode[ ((data[ (i * 3) + offset ] & 0x03) << 4) + ((data[ (i * 3) + 1 + offset ] & 0xf0) >> 4) ];
                out[ (i * 4) + 2 ] = forwardBytecode[ ((data[ (i * 3) + 1 + offset ] & 0x0f) << 2) + ((data[ (i * 3) + 2 + offset ] & 0xc0) >> 6) ];
                out[ (i * 4) + 3 ] = forwardBytecode[ (data[ (i * 3) + 2 + offset ] & 0x3f) ];
            }
        }

        return new String(out);
    }
}
