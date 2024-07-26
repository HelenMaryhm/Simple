package org.example.mime;

import org.apache.commons.codec.binary.Base64InputStream;
import org.example.mime.cmdgutils.YBase64;

import javax.annotation.Nonnull;
import javax.mail.MessagingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class QaMain {

    public static String digestBytes(byte[] decodedBytes, @Nonnull MessageDigest messageDigest) {
        messageDigest.update(decodedBytes);
        return YBase64.encode(messageDigest.digest(), false);
    }

    public static MessageDigest getMessageDigest(final String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            // If we caught NoSuchAlgorithmException the given algorithm is not supported by java.security.MessageDigest.
            // This should never happen as every implementation of the Java platform is required to support MD5, SHA-1, and SHA-256.
            throw new IllegalStateException(String.format("Unexpected JVM error. %s is not supported.", algorithm), e);
        }
    }

    public static int getByteLength(String str) {
        return str.getBytes().length;
    }

    public static void main(String[] args) throws MessagingException, IOException {
        System.out.println("Thank You Jesus");


//        String encodedString = "part-1 data";
//        System.out.println(getByteLength(encodedString));

//        String encodedString = "part-3 data";
//        try {
//            String decodedString = decodeBase64(encodedString);
//            System.out.println(decodedString.length());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static String decodeBase64(String encodedString) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encodedString.getBytes(StandardCharsets.UTF_8));
        Base64InputStream base64InputStream = new Base64InputStream(byteArrayInputStream);
        byte[] decodedBytes = base64InputStream.readAllBytes();
        for (byte decodedByte : decodedBytes) {
            System.out.println(decodedByte);
        }

        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    public static boolean areBracketsBalanced(String s)
    {
        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0
                        && ((stack[i] == '(' && ch == ')')
                        || (stack[i] == '{' && ch == '}')
                        || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1

//    String str = "cGFydC00IGRhdGE=";
//        System.out.println(getByteLength(str));
//        final String mime = "From: jouko <jouko@klikki.fi>\nSubject: HackerOne test\nTo: vastaus@rocketmail.com\nMIME-Version: 1.0\nContent-type: "
//                + "text/html\n\nTest case for https://jira.vzbuilders.com/browse/MAS-19596: \nNewline in quoted property value\n<style>\n    div {\n"
//                + "        font-family:\"foo\n        bar\";background:url(\"cid://x;position:fixed;left:0px;top:0px;right:0px;bottom:0px;"
//                + "z-index:99999;background:blue;color:white;\");\n    }\n</style>\nCarriage Return in quoted property value\n<style>\ndiv {\n"
//                + "font-family:\"foo\rbar\";background:url(\"cid://x;position:fixed;left:0px;top:0px;right:0px;bottom:0px;z-index:99999;"
//                + "background:blue;color:white;\");\n}\n</style>\nInline style attribute\n<div style=\"font-family:'foo\nbar';background:"
//                + "url('cid://x;position:fixed;left:0px;top:0px;right:0px;bottom:0px;z-index:99999;background:blue;color:white;');\"></div>";
//
//        System.out.println(mime);
//
//    }

//        final String content1 = "X-RocketTIP: 1.2.3.4\n" + "X-RocketSRV: allow=embedvid,paidvid\n"
//                + "Received: from [66.228.162.131] by combat.corp.yahoo.com:88 via HTTP; Tue, 17 Mar 2009 22:11:49 UTC\n"
//                + "To: Ben Shellack <bs@yahoo.com>\n" + "Subject: Yiv Certified Video Test Message"+ '\n'
//                + "Content-Type: text/html; charset=us-ascii\n"
//                + "MIME-Version: 1.0\n" + '\n' + "<XHTML-VIDEO-EMBED width=400px height=330px params=\"vid=http%3a%2f%2fvid.host.com"
//                + "%2farchive%2f20090315SpecialReport.flv%3fsenderParam1%3d1%26senderParam2%3d13213" + "&trackingid=12345565456&autoplay=true\"/>";
//
//        final String content2 = "<XHTML-VIDEO-EMBED width=400px height=330px params=\"vid=http%3a%2f%2fvid.host.com"
//                + "%2farchive%2f20090315SpecialReport.flv%3fsenderParam1%3d1%26senderParam2%3d13213" + "&trackingid=12345565456&autoplay=true\"/>";
//
//        final String content3 = "<XHTML-VIDEO-EMBED width=400px height=330px params=\"vid=http%3a%2f%2fvid.host.com"
//                + "%2farchive%2f20090315SpecialReport.flv%3fsenderParam1%3d1%26senderParam2%3d13213"
//                + "&trackingid=12345565456&altimage=http://www.images.com/imagehost.gif&autoplay=false\"/>";
//
//        compareStrings(content2, content3);
//        System.out.println(content2)

    public static void compareStrings(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println("Difference at index " + i + ":");
                System.out.println("String 1: " + str1.charAt(i));
                System.out.println("String 2: " + str2.charAt(i));
            }
        }
        if (str1.length() != str2.length()) {
            System.out.println("The strings have different lengths.");
            System.out.println("String 1 length: " + str1.length());
            System.out.println("String 2 length: " + str2.length());
        }
    }

















//                String str1 = """
//                part-3 data
//                """;//12 //uAgSD7/Ijed5afBKnJGeyDevuPwUpgHcD/UTfFFnGsA=

//        String str1 = """
//                part-4 data
//                """;//12 //6weUrDR20If7fnocpSf5R1DtCOrlWIZyLGkfydH2F/0=
//
//        System.out.println(getByteLength(str1));
//        System.out.println(digestBytes(str1.getBytes(), getMessageDigest(MessageDigestConstants.SHA256)));






        //V3GetMessageSimpleBodyBugsIT.testCertifiedVidForYiv2();
        //V3GetMessageSimpleBodyBugsIT.testGDMLargeTextAttachment();
        //V3GetMessageSimpleBodyBugsIT.testGetDisplayMessageBug4259018();

//        String str1 = """
//                part-1 data
//                """;
//        System.out.println(getByteLength(str1)); //12
//        System.out.println(digestBytes(str1.getBytes(), getMessageDigest(MessageDigestConstants.SHA256))); //o2lUiYu5q3yQcqPbKwLR3QE4T1k4J1xntLiU7es26oU=
//
//        String str2 = """
//                some data for part 1
//                """;
//        System.out.println(getByteLength(str2)); //21
//        System.out.println(digestBytes(str2.getBytes(), getMessageDigest(MessageDigestConstants.SHA256))); //gHLtNYBncNkQyVVKqCcrLrwuOp7IHHX4GT4CUtwI1nA=

//        String str3 = """
//                <html>
//                  <head>
//
//                    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
//                  </head>
//                  <body bgcolor="#FFFFFF" text="#000000">
//                    <img src="cid:part1.05000901.02000005@yahoo.com" alt="">
//                  </body>
//                </html>
//                """;
//        System.out.println(str3.getBytes().length);

//        int sum = 0;
//        for (char c : str3.toCharArray()) {
//
//            sum += String.valueOf(c).getBytes(StandardCharsets.UTF_8).length;
//
//        }
//        System.out.println( sum);
    }

