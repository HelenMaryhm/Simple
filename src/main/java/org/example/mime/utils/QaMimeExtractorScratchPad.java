package org.example.mime.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.mail.Header;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.mail.util.SharedByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Properties;


public class QaMimeExtractorScratchPad {

    private static final String inputFilePathSinglePart =
            "/Users/hmaryt/Documents/TYJ/jedi/apps/qa/qa_common/src/main/resources/com/yahoo/mail/qa/messages/htmlPartWithTextAsPartId.msg";
    private static final String inputFilePathMultipart =
            "/Users/hmaryt/Documents/TYJ/jedi/apps/qa/qa_common/src/main/resources/com/yahoo/mail/qa/messages/msgWithPDF.msg";
    private static final String inputFilePath =
            "/Users/hmaryt/Documents/TYY/core-mail-data-web-services/qa/qa-gateway/src/main/resources/messageFetchSuccess/Inbox1KB.msg";
    private static final String outputFilePath =
            "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/resources/jedi/manual-scripts/01_V3GetMessageSimpleBodyAttachmentsIT/01_01_testGetMessageSimpleBodyWithAttachmentHasTwoHeaders/response-01.msg";
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws MessagingException, IOException {

    }

    public static InputStream getFileAsFileInputStream(String filePath) throws IOException {
        try {
            Path path = Path.of(filePath);
            return new FileInputStream(path.toFile()); // better performance than byte array input stream
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static MimeMessage getMimeMessageFromInputStream(InputStream is) throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.mime.address.strict", "false");
        Session session = Session.getInstance(props);
        return new MimeMessage(session, is);
    }

    public static MimeMessage getMimeMessageFromFilePath(String filePath) throws IOException, MessagingException {
        InputStream is = getFileAsFileInputStream(filePath);
        return getMimeMessageFromInputStream(is);
    }

    public static void validateMultiPart(MimeMultipart inputMultipart, MimeMultipart outputMultipart) throws MessagingException {

        // Iterate through each part
        for (int i = 0; i < inputMultipart.getCount(); i++) {
            // Process each part...
            // For example, extract part content, headers, etc.
            //System.out.println("Part " + i + ": " + multipart.getBodyPart(i).getContent().toString());

            //System.out.println("Part " + i + ": " + multipart.getBodyPart(i).getContent());

        }
    }

    public static void validateSinglePart(MimeMessage input, MimeMultipart output) throws MessagingException, IOException {
        // Handle single part messages
        //                System.out.println("Single part message: " + message.getContent().toString());

        String htmlContent = input.getContent().toString();
        // Convert HTML string to byte array
        byte[] bytes = htmlContent.getBytes(java.nio.charset.StandardCharsets.UTF_8);

        // Encode to Base64
        String encodedContent = Base64.getEncoder().encodeToString(bytes);
        System.out.println(encodedContent);
    }

    public static MimeMultipart getMimeMultipart(MimeMessage mimeMessage) throws MessagingException, IOException {
        Object object = mimeMessage.getContent();
        if (object instanceof InputStream) {
            ByteArrayDataSource dataSource = new ByteArrayDataSource((InputStream) mimeMessage.getContent(), "application/octet-stream");
            return new MimeMultipart(dataSource);
        } else {
            throw new IOException("The content is single part.");
        }
    }

    public static MimeMultipart getMimeMultipartFromStream(InputStream inputStream) throws MessagingException, IOException {
        try {
            ByteArrayDataSource dataSource = new ByteArrayDataSource(inputStream, "application/octet-stream");
            return new MimeMultipart(dataSource);
        }catch (Exception e){
            throw new IOException("The content is single part.\n"+e.getMessage());
        }
    }

    public static void printInputMimeStructure(String filePath) {
        try {
            MimeMessage input = getMimeMessageFromFilePath(filePath);

            Enumeration mainHeaders = input.getAllHeaders();
            // main headers
            while (mainHeaders.hasMoreElements()) {
                Header header = (Header) mainHeaders.nextElement();
                //System.out.println(header.getName() + " : " + header.getValue());
            }
            // main content
            String className = input.getContent().getClass().getName();
            //System.out.println(className);

            // Process the content. If String, single part. So filename is 1.
            if(className.equalsIgnoreCase("java.lang.String")){
                System.out.println("Single part message");
                System.out.println(input.getContentType()); //text/plain ; then file name is filename="TEXT"; name="TEXT"
                //System.out.println(input.getContent()); //String if single part
            }else if(className.equalsIgnoreCase("javax.mail.internet.MimeMultipart")){

                // Process the content. If MimeMultipart, multi part. So filename is 1, 2, 3, etc.

                MimeMultipart mimeMultipart = (MimeMultipart) input.getContent();
                //System.out.println(mimeMultipart.getCount());
                //System.out.println("Preamble:"+mimeMultipart.getPreamble()); //null
                for (int i = 0; i < mimeMultipart.getCount(); i++) {

                    // check the classname of the part. If it is a BASE64DecoderStream, it is a file, else it is a multipart.

                    MimeBodyPart mimeBodyPart = (MimeBodyPart) mimeMultipart.getBodyPart(i);
                    //System.out.println(mimeBodyPart.getContentType());
                    String partClassName = mimeBodyPart.getContent().getClass().getName();
                    System.out.println(partClassName); // if alternative- should have 1.1 and next if not multipart 1.2;
                    //System.out.println(mimeBodyPart.getDisposition());//null; attachment;
                    System.out.println(mimeBodyPart.getContentType()); //null; sample-pdf.pdf;
                    /*
                    CASE 1:
                    Input has two parts-
                        (i) javax.mail.internet.MimeMultipart
                        (ii) com.sun.mail.util.BASE64DecoderStream

                        Their content types are-
                        (i) multipart/alternative; boundary="-1195379013-681422013-1361901172=:29394"
                        (ii) application/pdf; name="sample-pdf.pdf"

                        Output has two parts-
                        (i) 1.1
                        (ii) 1.2

                     CASE 2:




                     */



//                    if(partClassName.equalsIgnoreCase("com.sun.mail.util.BASE64DecoderStream")) {
//                        System.out.println("File name: " + i+1);
//                    }else if(partClassName.equalsIgnoreCase("javax.mail.internet.MimeMultipart")){
//                        MimeMultipart mimeMultipart1 = (MimeMultipart) mimeBodyPart.getContent();
//                        System.out.println(mimeMultipart1.getCount());
//                        System.out.println("Preamble:"+mimeMultipart1.getPreamble()); //null
//                        for (int j = 0; j < mimeMultipart1.getCount(); j++) {
//                            MimeBodyPart mimeBodyPart1 = (MimeBodyPart) mimeMultipart1.getBodyPart(j);
//                            System.out.println(mimeBodyPart1.getContentType());
//                            System.out.println(mimeBodyPart1.getDisposition());
//                            System.out.println(mimeBodyPart1.getFileName());
//                            System.out.println(mimeBodyPart1.getContent());
//                            System.out.println("**************************************************************************************");
//                        }
//
//                    }

                    /*
                    0  --->  multipart/alternative; boundary="-1195379013-681422013-1361901172=:29394"
                    1  --->  application/pdf; name="sample-pdf.pdf"

                     */

                    //System.out.println(mimeBodyPart.getDisposition()); //null; attachment;
                    //System.out.println(mimeBodyPart.getFileName()); //null; sample-pdf.pdf;
                    //System.out.println(mimeBodyPart.getContent()); //javax.mail.internet.MimeMultipart@23fe1d71 (alternative); com.sun.mail.util.BASE64DecoderStream@544a2ea6 (application/pdf)
                    //System.out.println("**************************************************************************************");
                }
            }else{
                //System.out.println("Unknown content type");
            }
        } catch (MessagingException | IOException e) {
            System.out.println("Error in input mime");
        }
    }

        public static void printOutputMimeStructure(String filePath) throws MessagingException, IOException {
            MimeMessage output = getMimeMessageFromFilePath(outputFilePath);
            String className = output.getContent().getClass().getName();
            System.out.println(className); //javax.mail.util.SharedByteArrayInputStream

            if(className.equalsIgnoreCase("javax.mail.util.SharedByteArrayInputStream")){
                SharedByteArrayInputStream sharedByteArrayInputStream = (SharedByteArrayInputStream) output.getContent();
                ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
                MimeMultipart multipart = new MimeMultipart(dataSource);
                Enumeration mainHeaders = output.getAllHeaders();
                while(mainHeaders.hasMoreElements()){
                    Header header = (Header) mainHeaders.nextElement();
                    System.out.println(header.getName() + " : " + header.getValue());
                }
                //System.out.println(multipart.getCount()); //5
                //System.out.println(multipart.getPreamble());
                for (int i = 0; i < multipart.getCount(); i++) {
                    System.out.println("Part "+i);
                    Enumeration headers = multipart.getBodyPart(i).getAllHeaders();
                    while(headers.hasMoreElements()){
                        Header header = (Header) headers.nextElement();
                        System.out.println(header.getName() + " : " + header.getValue());
                    }

                    System.out.println("**************************************************************************************");

                    String fileNameOfPart;
                    String partClassname = multipart.getBodyPart(i).getContent().getClass().getName();
                    System.out.println("PartClassName: "+partClassname);
                    if(partClassname.equalsIgnoreCase("com.sun.mail.util.BASE64DecoderStream")){
                        fileNameOfPart = i+"";
                        System.out.println("File name: " + fileNameOfPart);

                    }else if(partClassname.equalsIgnoreCase("javax.mail.internet.MimeMultipart")){
                        MimeMultipart mimeMultipart = (MimeMultipart) multipart.getBodyPart(i).getContent();
                        System.out.println(mimeMultipart.getCount());
                        System.out.println("Preamble:"+mimeMultipart.getPreamble()); //null
                        for (int j = 0; j < mimeMultipart.getCount(); j++) {
                            MimeBodyPart mimeBodyPart = (MimeBodyPart) mimeMultipart.getBodyPart(j);
                            System.out.println(mimeBodyPart.getContentType());
                            /*
                            0  --->  multipart/alternative; boundary="-1195379013-681422013-1361901172=:29394"
                            1  --->  application/pdf; name="sample-pdf.pdf"

                             */

                            System.out.println(mimeBodyPart.getDisposition()); //null; attachment;
                            System.out.println(mimeBodyPart.getFileName()); //null; sample-pdf.pdf;
                            System.out.println(mimeBodyPart.getContent()); //javax.mail.internet.MimeMultipart@23fe1d71 (alternative); com.sun.mail.util.BASE64DecoderStream@544a2ea6 (application/pdf)
                            System.out.println("**************************************************************************************");
                        }

                    }else if(partClassname.equalsIgnoreCase("javax.mail.util.SharedByteArrayInputStream")){
                        System.out.println(getStringFromStream((SharedByteArrayInputStream) multipart.getBodyPart(i).getContent()));

                    }else{
                        System.out.println("&&&&&&&&&&&&&&&&&");
                    }


                    System.out.println("**************************************************************************************");
                }

            }else{
                System.out.println("Unknown content type for output");
            }

        }

    public static String getStringFromStream(InputStream stream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = stream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8);
    }

    public static void validateMime(MimeMessage input, MimeMessage output) {
        try {
            MimeMultipart multipartOutput = (MimeMultipart) output.getContent();
            if (input.isMimeType("multipart/*")) {
                MimeMultipart multipartInput = (MimeMultipart) input.getContent();
                validateMultiPart(multipartInput, multipartOutput);
            } else {
                validateSinglePart(input, multipartOutput);
            }
        } catch (MessagingException | IOException e) {
            System.out.println("Error in input mime");
        }
    }

    //System.out.println(input.getContentType());//text/plain
//        ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
//        MimeMultipart multipart = new MimeMultipart(dataSource);
//


    //MimeMessage output = getMimeMessageFromFilePath(outputFilePath);
    //System.out.println(output.getContent()); //javax.mail.util.SharedByteArrayInputStream@3b22cdd0
    //System.out.println(output.getAllHeaders().nextElement()); //javax.mail.Header@48cf768c
    //System.out.println(output.getAllHeaderLines().nextElement()); //--Boundary_3_738260980_1720685625900

    //try {
    //System.out.println(getStringFromStream(output.getInputStream())); //full message
            /*
            Enumeration mainHeaders = output.getAllHeaders();
            while(mainHeaders.hasMoreElements()){
                Header header = (Header) mainHeaders.nextElement();
                //System.out.println(header.getName() + " : " + header.getValue());
            }*/
            /*
            --Boundary_3_738260980_1720685625900 : --Boundary_3_738260980_1720685625900
            Content-Type : application/json
            Content-Disposition : form-data; name="MULTI_PART_HEADER"
             */
    //SharedByteArrayInputStream sharedByteArrayInputStream = (SharedByteArrayInputStream) output.getContent();

    //ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/json");
            /*ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
            MimeMultipart multipart = new MimeMultipart(dataSource);
            System.out.println(multipart.getCount());
            System.out.println(multipart.getPreamble());*/
            /*
            {"folder":{"id":1,"name":"Inbox","acctId":1,"type":["M"],"deletedId":0,"size":100,"count":1,"unseen":0,"highestModSeq":2,"uidNext":2,"uidValidity":1720681702},"message":{"folderId":1,"mimeId":"9SfP+a+x3kXa","size":100,"internalDate":1631539200000,"dedupId":1,"flags":{"answer":false,"attachment":false,"flagged":false,"ham":false,"personIKnow":false,"draft":false,"certified":false,"spam":true,"recent":false,"forwarded":false,"seen":true},"fromEmail":"test_email@yahoo.com","toAddr":["to_test_email@yahoo.com"],"subject":"Test Subject","acctId":1,"threadId":1,"uid":1,"auid":1,"ymumId":"1","purgeTsSec":1631539200,"enhancedChangeTsMs":1720682280622,"references":["F8HDSJPpPtf"],"referencesReal":["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]},"structure":{"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain; charset=iso-8859-1"],"Content-Transfer-Encoding":["8bit"]},"size":190,"pid":"1"},"2":{"parsedMimeHeaders":{"Content-Type":["message/rfc822"],"Content-Transfer-Encoding":["8bit"]},"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["multipart/alternative; boundary=\"0-1054241370-1146072583=:24642\""]},"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain; charset=iso-8859-1"],"Content-Transfer-Encoding":["8bit"]},"size":150,"pid":"2.1.1"},"2":{"parsedMimeHeaders":{"Content-Type":["text/html; charset=iso-8859-1"],"Content-Transfer-Encoding":["8bit"]},"size":252,"pid":"2.1.2"}},"size":659,"pid":"2.1"},"2":{"parsedMimeHeaders":{"Content-Type":["message/rfc822"]},"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain;\tcharset=\"us-ascii\""],"Content-Transfer-Encoding":["quoted-printable"]},"size":305,"pid":"2.2.1"},"2":{"parsedMimeHeaders":{"Content-Disposition":["attachment"],"Content-Type":["application/ms-tnef;\tname=\"winmail.dat\""],"Content-Transfer-Encoding":["base64"]},"size":765899,"pid":"2.2.2"}}},"size":1037757,"parsedRFC822Headers":{"X-Apparently-To":["alam1128@yahoo.com via 68.142.207.161; Tue, 13 Sep 2005 10:03:45 -0700"],"X-Originating-Ip":["[64.233.184.192]"],"Authentication-Results":["mta204.mail.dcn.yahoo.com  from=hp.com; domainkeys=neutral (no sig)"],"Received":["from 64.233.184.192  (EHLO wproxy.gmail.com) (64.233.184.192)  by mta204.mail.dcn.yahoo.com with SMTP; Tue, 13 Sep 2005 10:02:04 -0700","by wproxy.gmail.com with SMTP id 58so2267595wri        for <alam1128@yahoo.com>; Tue, 13 Sep 2005 10:01:34 -0700 (PDT)","by 10.54.44.11 with SMTP id r11mr621830wrr;        Tue, 13 Sep 2005 10:01:33 -0700 (PDT)","by 10.54.11.52 with SMTP id 52cs16531wrk;        Tue, 13 Sep 2005 10:01:32 -0700 (PDT)","by 10.37.13.69 with SMTP id q69mr941154nzi;        Tue, 13 Sep 2005 10:01:30 -0700 (PDT)","from palrel11.hp.com (palrel11.hp.com [156.153.255.246])        by mx.gmail.com with ESMTP id 20si1202730nzp.2005.09.13.10.01.25;        Tue, 13 Sep 2005 10:01:30 -0700 (PDT)","from cacexg11.americas.cpqcorp.net (cacexg11.americas.cpqcorp.net [16.92.1.67])\tby palrel11.hp.com (Postfix) with ESMTP id B85004894;\tTue, 13 Sep 2005 10:01:23 -0700 (PDT)","from cacexc04.americas.cpqcorp.net ([16.92.1.26]) by cacexg11.americas.cpqcorp.net with Microsoft SMTPSVC(6.0.3790.211);\t Tue, 13 Sep 2005 10:00:24 -0700"],"X-Forwarded-To":["alam1128@yahoo.com"],"X-Forwarded-For":["alam17@gmail.com alam1128@yahoo.com"],"X-Gmail-Received":["ac37aa4d02bfe5699aa95e15f826b007131ca277"],"Delivered-To":["alam17@gmail.com"],"Received-Spf":["pass (gmail.com: domain of betty.lam@hp.com designates 156.153.255.246 as permitted sender)"],"X-Mimeole":["Produced By Microsoft Exchange V6.5.7226.0"],"Content-Class":["urn:content-classes:message"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed;\tboundary=\"----_=_NextPart_001_01C5B884.A15080D0\""],"Subject":["FW: sally & us"],"Date":["Tue, 13 Sep 2005 10:00:23 -0700"],"X-Ms-Has-Attach":["yes"],"X-Ms-Tnef-Correlator":["<B6C7F31B85669143825614FC8FE6492903AA6C7C@cacexc04.americas.cpqcorp.net>"],"Thread-Topic":["sally & us"],"Thread-Index":["AcW4drLsslD1xH1lTJqZ5P1FKR7F7AADdoHg"],"From":["\"Lam, Betty\" <betty.lam@hp.com>"],"To":["\"Amy Wong\" <amwong@adobe.com>,\t\"Alberto Lam\" <lamalberto@netscape.net>,\t\"Antonio Lam\" <alam17@gmail.com>,\t\"Connie Lau\" <connielau1128@gmail.com>,\t\"Joshua Clark\" <joshuayclark@yahoo.com>,\t\"Lily Lam\" <Lilyqliu@netscape.net>"],"X-Originalarrivaltime":["13 Sep 2005 17:00:24.0398 (UTC) FILETIME=[A20E7EE0:01C5B884]"],"Content-Length":["778697"]},"pid":"2.2"}}},"size":1039821,"parsedRFC822Headers":{"X-Apparently-To":["tracyhsu1798@yahoo.com via 68.142.207.160; Wed, 26 Apr 2006 10:29:44 -0700"],"X-Originating-Ip":["[68.142.207.151]"],"Authentication-Results":["mta287.mail.mud.yahoo.com  from=yahoo.com; domainkeys=pass (ok)"],"Received":["from 68.142.207.151  (HELO web32303.mail.mud.yahoo.com) (68.142.207.151)  by mta287.mail.mud.yahoo.com with SMTP; Wed, 26 Apr 2006 10:29:43 -0700","(qmail 26487 invoked by uid 60001); 26 Apr 2006 17:29:43 -0000","from [216.145.54.158] by web32303.mail.mud.yahoo.com via HTTP; Wed, 26 Apr 2006 10:29:43 PDT"],"Domainkey-Signature":["a=rsa-sha1; q=dns; c=nofws;  s=s1024; d=yahoo.com;  h=Message-ID:Received:Date:From:Subject:To:MIME-Version:Content-Type:Content-Transfer-Encoding;  b=0KGAB7RumiDpt4ilyo0M9C40FqPmV/3Z0W0ecn5iGFI2T0/c2GGXaxXVQg81kbwjmK5vnx+M07IXwJdBZZTwn9bn8y3ZNPTSq73iyZL9O2cMdpe90krD5sshGiVLM4u58rSLgXC3LGX3Gr/z8YtyitbiA/cbWYEMc67CZTx/pws=  ;"],"Date":["Wed, 26 Apr 2006 10:29:43 -0700 (PDT)"],"From":["cg test cg test <buggy_messages@yahoo.com>"],"Subject":["Fwd: FW: sally & us"],"To":["tracyhsu1798@yahoo.com"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed; boundary=\"0-766657669-1146072583=:24642\""],"Content-Transfer-Encoding":["8bit"],"Content-Length":["780220"]},"pid":"2"}},"size":1040254,"pid":"TEXT"},"parsedRFC822Headers":{"X-Apparently-To":["buggy_messages@yahoo.com via 68.142.207.151; Wed, 19 Jul 2006 18:02:52 -0700"],"Received":["from 68.142.207.151  (HELO web32303.mail.mud.yahoo.com) (68.142.207.151)  by mta107.mail.re4.yahoo.com with SMTP; Wed, 19 Jul 2006 18:02:51 -0700","(qmail 70198 invoked by uid 60001); 20 Jul 2006 01:02:45 -0000","from [216.145.49.15] by web32303.mail.mud.yahoo.com via HTTP; Wed, 19 Jul 2006 18:02:45 PDT"],"Message-Id":["<20060720010245.70182.qmail@web32303.mail.mud.yahoo.com>"],"Date":["Wed, 19 Jul 2006 18:02:45 -0700 (PDT)"],"From":["\"tracyhsu1798@yahoo.com\" <tracyhsu1798@yahoo.com>"],"Reply-To":["tracyhsu1798@yahoo.com"],"Subject":["Fwd: FW: sally & us"],"To":["buggy_messages@yahoo.com"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed; boundary=\"0-1634966140-1153357365=:69162\""],"Content-Transfer-Encoding":["8bit"]}}}
             */





            /* working
            SharedByteArrayInputStream sharedByteArrayInputStream = (SharedByteArrayInputStream) output.getContent();

            System.out.println(output.getContentType());

            ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
            MimeMultipart multipart = new MimeMultipart(dataSource);
            //System.out.println(multipart.getCount());
            //System.out.println("**************************************************************************************");
            for (int i = 0; i < multipart.getCount(); i++) {

                Enumeration headers = multipart.getBodyPart(i).getAllHeaders();
                while(headers.hasMoreElements()){
                    Header header = (Header) headers.nextElement();
                    System.out.println(header.getName() + " : " + header.getValue());
                }

                System.out.println("**************************************************************************************");

                System.out.println(getStringFromStream((SharedByteArrayInputStream) multipart.getBodyPart(i).getContent()));
                System.out.println("**************************************************************************************");
            }*/
            /*
application/json
Content-Type : application/octet-stream
Content-Disposition : form-data; filename="1"; name="1"
**************************************************************************************

Note: forwarded message attached.


__________________________________________________
Do You Yahoo!?
Tired of spam?  Yahoo! Mail has the best spam protection around
http://mail.yahoo.com
**************************************************************************************
Content-Type : application/octet-stream
Content-Disposition : form-data; filename="2.1.1"; name="2.1.1"
**************************************************************************************


Note: forwarded message attached.

---------------------------------
How low will we go? Check out Yahoo! Messenger�s low  PC-to-Phone call rates.
**************************************************************************************
Content-Type : application/octet-stream
Content-Disposition : form-data; filename="2.1.2"; name="2.1.2"
**************************************************************************************
<BR><BR>Note: forwarded message attached.<p>
                <hr size=1>How low will we go? Check out Yahoo! Messenger�s low <a href="http://us.rd.yahoo.com/mail_us/taglines/postman8/*http://us.rd.yahoo.com/evt=39663/*http://voice.yahoo.com"> PC-to-Phone call rates.
**************************************************************************************
Content-Type : application/octet-stream
Content-Disposition : form-data; filename="2.2.1"; name="2.2.1"
**************************************************************************************
Picture with Sally :)
=20
-----Original Message-----
From: Tom, Jocelyn Lee=20
Sent: Tuesday, September 13, 2005 8:21 AM
To: Lam, Betty; Liu, Sarah Shuxia
Cc: Tom, Jocelyn Lee; Wong, Gloria
Subject: sally & us


    sorry, pictures didn't turn out really good - shaky hands or=20
    too dark :(
=20

**************************************************************************************
Content-Type : application/json
Content-Disposition : form-data; name="MULTI_PART_FOOTER"
**************************************************************************************
{"bodyPartsMeta":{"streamedDataMeta":{"1":{"dataCRC":482306151,"contentLength":197},"2.1.1":{"dataCRC":1610356496,"contentLength":155},"2.1.2":{"dataCRC":250454967,"contentLength":253},"2.2.1":{"dataCRC":2140788849,"contentLength":313}}},"responseSummary":{"sid":77,"succeeded":["1","2.1.1","2.1.2","2.2.1"],"failed":[],"status":"SUCCESS"}}
**************************************************************************************

             */


//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    //validateMime(input, output);
//    }


}