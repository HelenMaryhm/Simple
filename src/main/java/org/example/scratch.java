package org.example;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Enumeration;
import java.io.*;
public class scratch {

    public static void main(String[] args) throws MessagingException {

        String emailHeaders = "Received: from 10.197.33.76\n" +
                " by atlas209.free.mail.bf1.yahoo.com with HTTPS; Sat, 30 Apr 2022 10:05:35 +0000\n" +
                "Return-Path: <ShannonTMiller@openboard-ports.net>\n" +
                "Received: from 155.254.192.32 (EHLO WVwyHW.smartphotographics.com)\n" +
                " by 10.197.33.76 with SMTPs\n" +
                " (version=TLS1_0 cipher=TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);\n" +
                " Sat, 30 Apr 2022 10:05:35 +0000\n" +
                "Delivered-To: test@yahoo.com\n" +
                "Received: by mail-pg0-x239.google.com with SMTP id 187sf543217pgc.1;\n" +
                "        Sat, 30 Apr 2022 10:05:17 +0000 (UTC)\n" +
                "Sender: test@yahoo.com\n" +
                "X-Received: by 10.36.123.4 with SMTP id q4mr60283itc.0.1493964919480;\n" +
                "        Sat, 30 Apr 2022 10:05:17 +0000 (UTC)\n" +
                "Received: by 10.36.34.149 with SMTP id o143ls226635ito.2.gmail; Sat, 30 Apr 2022 10:05:17 +0000 (UTC)\n" +
                "X-Received: by 10.99.4.85 with SMTP id 82mr527519pge.70.1493964917786;\n" +
                "       Sat, 30 Apr 2022 10:05:17 +0000 (UTC)\n" +
                "From: =?UTF-8?B?IiIiIiIiImBTY2h3YW7igJlzICAgYEhvbWUgICBEZWxpdmVyeSAgIGBUZWFtIiIiIiIiIg==?= <test@test-ports.net>\n" +
                "To: <test@yahoo.com>\n" +
                "Subject: =?UTF-8?B?YFdob0llc29tZSAgICBgaW5ncmVkaWVudHMgIHlvdSAgY3JhdmUsICAgIGByZWFkeSAgICBpbiAgIGBtaW51dGVzLg==?=\n" +
                "Date: Sat, 30 Apr 2022 10:05:17 +0000 (UTC)\n" +
                "Message-ID: <1651313117.1383.7333551594@be106.member.sg3.yahoo.com>\n" +
                "MIME-Version: 1.0\n" +
                "Content-Type: multipart/mixed; boundary=\"----=_NextPart_000_1878_A9S5O59Q.A9S5O59Q\"\n" +
                "X-Mailer: Microsoft Outlook 14.0\n" +
                "Thread-Index: AdLFZuUOxC4giHDHSCSny67CCj8VBQ==\n" +
                "Content-Language: en-us\n" +
                "Content-Length: 168301";

        // Convert the raw email string to an InputStream
        InputStream is = new ByteArrayInputStream(emailHeaders.getBytes());

        // Create a new empty Session object
        Session session = Session.getDefaultInstance(System.getProperties());

        // Create a new MimeMessage object and load it with the raw email
        MimeMessage message = new MimeMessage(session, is);

        // Get all headers
        Enumeration headers = message.getAllHeaders();
        while (headers.hasMoreElements()) {
            Header header = (Header) headers.nextElement();
            System.out.println(header.getName() + "  &&&&&&&& " + header.getValue());
            System.out.println("");
        }


    }
}
