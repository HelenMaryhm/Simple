package org.example.mime.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.mime.beans.MessageStructureBean;
import org.example.mime.beans.MessageStructurePart;
import org.example.mime.beans.StreamedMultipartFooterResponse;
import org.example.mime.beans.UnknownCharsetString;

import javax.mail.Header;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.mail.util.SharedByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class QaMimeValidator {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private QaMimeValidator() {

    }

    /**
     * 1. Assert main headers
     * 2. Assert Part count
     * 3. Asser Part headers and content
     * 3. MessageStructure validation
     * 4. MessageMetaData validation
     */
    public static void validateMimeMessage(MimeMessage input, MimeMessage output) throws MessagingException, IOException {

        MimeMultipart outputMimeMultipart = getMimeMultipart(output);
        MessageStructureBean messageStructureBean = getPreamble(outputMimeMultipart);
        StreamedMultipartFooterResponse footer = getFooter(outputMimeMultipart.getBodyPart(outputMimeMultipart.getCount()-1).getContent());
        /*
        WORKING
        assertMainHeaders(enumerationToList(getHeaders(input)), messageStructureBean.getMessageStructurePartBean().getParsedRFC822Headers());
        assertPartCount(input, outputMimeMultipart);
         */

        assertPartHeadersAndContent(input, output, messageStructureBean);

    }



    private static void assertPartHeadersAndContent(MimeMessage inputMimeMessage, MimeMessage outputMimeMessage,
                                                    MessageStructureBean messageStructureBean) throws MessagingException, IOException {

        String className = inputMimeMessage.getContent().getClass().getName();
        if(className.equalsIgnoreCase("java.lang.String")){
            MimeBodyPart outputMimeBodyPart = getMimeBodyPartFromSharedByteArrayInputStream((SharedByteArrayInputStream) outputMimeMessage.getContent());
            validateSinglePart(inputMimeMessage, outputMimeBodyPart);
        }else if (className.equalsIgnoreCase("javax.mail.internet.MimeMultipart")) {
            MimeMultipart input = (MimeMultipart) inputMimeMessage.getContent();
            MimeMultipart output = getMimeMultipartFromSharedByteArrayInputStream((SharedByteArrayInputStream) outputMimeMessage.getContent());
            validateMultiPart(input, output, messageStructureBean);
        }else{
            throw new IOException("Exception in assertPartHeadersAndContent");
        }
    }

    private static void validateMultiPart(MimeMultipart input, MimeMultipart output, MessageStructureBean messageStructureBean)
            throws MessagingException, IOException {
        for(int i=0; i<input.getCount(); i++){
            System.out.println("Part"+(i+1));
            validateHeaders(input.getBodyPart(i).getAllHeaders(), output.getBodyPart(i).getAllHeaders(), messageStructureBean);
            //validateParts(input.getBodyPart(i).getContent());
        }
    }

    private static void validateParts(){

    }

    private static void validateHeaders(Enumeration<Header> input, Enumeration<Header> output, MessageStructureBean messageStructureBean){
        while(input.hasMoreElements()){
            Header inputHeader = input.nextElement();
            System.out.println("Input Header: ");
            System.out.println(inputHeader.getName() + " : " + inputHeader.getValue());
            // Content-Type : multipart/alternative; boundary="-1195379013-681422013-1361901172=:29394"
            // Content-Type : application/pdf; name="sample-pdf.pdf"
            //
        }
        while (output.hasMoreElements()){
            Header outputHeader = output.nextElement();
            System.out.println("Output Header: ");
            System.out.println(outputHeader.getName() + " : " + outputHeader.getValue());
            // Content-Type : application/octet-stream
            // Content-Disposition : form-data; filename="1.1"; name="1.1"
        }
        //System.out.println(messageStructureBean); // org.example.mime.beans.MessageStructureBean@13e39c73
       //System.out.println(messageStructureBean.getMessageStructurePartBean()); //MessageStructurePart{pid='null', size=null, sha256='null', docTree='MessageStructurePart{pid='TEXT', size=297563, sha256='null', docTree='null', parsedRFC822Headers='null', parts='{1=MessageStructurePart{pid='1', size=488, sha256='null', docTree='null', parsedRFC822Headers='null', parts='{1=MessageStructurePart{pid='1.1', size=51, sha256='null', docTree='null', parsedRFC822Headers='null', parts='null', parsedMimeHeaders='{Content-Type=[UnknownCharsetString{value='text/plain; charset=us-ascii'}]}', oid='null', org.example.mime.beans.MessageStructurePart@1725dc0f}, 2=MessageStructurePart{pid='1.2', size=221, sha256='null', docTree='null', parsedRFC822Headers='null', parts='null', parsedMimeHeaders='{Content-Type=[UnknownCharsetString{value='text/html; charset=us-ascii'}]}', oid='null', org.example.mime.beans.MessageStructurePart@3911c2a7}}', parsedMimeHeaders='{Content-Type=[UnknownCharsetString{value='multipart/alternative; boundary="-1195379013-681422013-1361901172=:29394"'}]}', oid='null', org.example.mime.beans.MessageStructurePart@31368b99}, 2=MessageStructurePart{pid='2', size=218882, sha256='null', docTree='null', parsedRFC822Headers='null', parts='null', parsedMimeHeaders='{Content-Type=[UnknownCharsetString{value='application/pdf; name="sample-pdf.pdf"'}], Content-Transfer-Encoding=[UnknownCharsetString{value='base64'}], Content-Disposition=[UnknownCharsetString{value='attachment; filename="sample-pdf.pdf"'}]}', oid='null', org.example.mime.beans.MessageStructurePart@4ac3c60d}}', parsedMimeHeaders='null', oid='null', org.example.mime.beans.MessageStructurePart@50b472aa}', parsedRFC822Headers='{Date=[UnknownCharsetString{value='Tue, 26 Feb 2013 09:52:52 -0800 (PST)'}], From=[UnknownCharsetString{value='Test User<testuser@yahoo-inc.com>'}], Reply-To=[UnknownCharsetString{value='Test User <testuser@yahoo-inc.com>'}], Subject=[UnknownCharsetString{value='sample pdf'}], To=[UnknownCharsetString{value='"anothertester@yahoo.com" <anothertester@yahoo.com>'}], Mime-Version=[UnknownCharsetString{value='1.0'}], Content-Type=[UnknownCharsetString{value='multipart/mixed; boundary="-1195379013-343248129-1361901172=:29394"'}], Content-Length=[UnknownCharsetString{value='297469'}]}', parts='null', parsedMimeHeaders='null', oid='null', org.example.mime.beans.MessageStructurePart@64cd705f}
        //System.out.println(messageStructureBean.getMessageStructurePartBean().getDocTree());
        System.out.println(messageStructureBean.getMessageStructurePartBean().getDocTree().getParts().size());//2 assert this
        for(Map.Entry<String, MessageStructurePart> entry: messageStructureBean.getMessageStructurePartBean().getDocTree().getParts().entrySet()){
            System.out.println("Parts: " + entry.getKey()); // 1, 2
            //System.out.println("MessageStructurePart"+entry.getValue());
            System.out.println("MessageStructurePart"+entry.getValue().getParsedMimeHeaders());
//            System.out.println(entry.getValue().getParsedMimeHeaders());
//            entry.getValue().getParts().forEach((k,v) -> {
//                System.out.println("PartsK"+k);
//                System.out.println("PartsV"+v);
//            });
        }

//        System.out.println(messageStructureBean.getMessageStructurePartBean().getParsedMimeHeaders()); // null
//        System.out.println(messageStructureBean.getMessageStructurePartBean().getParts()); //null
//        for(Map.Entry<String, MessageStructurePart> entry : parts.entrySet()){
//            System.out.println("Part: " + entry.getKey());
//            System.out.println(entry.getValue().getParsedMimeHeaders());
//            entry.getValue().getParts().forEach((k,v) -> {
//                System.out.println("PartsK"+k);
//                System.out.println("PartsV"+v);
//            });
//
//        }
        /*
        Part 1
        Input Header: Content-Type : multipart/alternative; boundary="-1195379013-681422013-1361901172=:29394"
        Output Header: Content-Type : application/octet-stream; Content-Disposition : form-data; filename="1.1"; name="1.1"
        Output Header: Content-Type : application/octet-stream; Content-Disposition :  form-data; filename="1.2"; name="1.2"

        Part 2
        Input Header: Content-Type : application/pdf; name="sample-pdf.pdf"; Content-Transfer-Encoding : base64; Content-Disposition : attachment; filename="sample-pdf.pdf"










         */




    }

    private static void validateSinglePart(MimeMessage input, MimeBodyPart output) throws MessagingException, IOException {
        System.out.println("&&&&&&& Single Part &&&&&&&&");
        System.out.println(input.getContentType());
        if(input.getContentType().equalsIgnoreCase("text/plain")){

            assert Objects.equals(output.getContentType(), input.getContentType());
           // System.out.println(input.getContent());
            MimeMultipart outputMimeMultipart = getMimeMultipartFromSharedByteArrayInputStream((SharedByteArrayInputStream) output.getContent());
            //System.out.println(outputMimeMultipart.getCount());//2
            //System.out.println(getStringFromStream((SharedByteArrayInputStream) outputMimeMultipart.getBodyPart(0).getContent()));
            assert Objects.equals(input.getContent(), getStringFromStream((SharedByteArrayInputStream) outputMimeMultipart.getBodyPart(0).getContent()));
        }
        //System.out.println(input.getContentType()); //text/plain ; then file name is filename="TEXT"; name="TEXT"

    }

    private static void assertMessageStructure(MimeMessage input, MimeMessage output) {

    }

    private static void assertMessageMetaData(MimeMessage input, MimeMessage output) {

    }

    private static Enumeration<Header> getHeaders(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getAllHeaders();
    }

    private static List<Header> enumerationToList(Enumeration<Header> headers) {
        return Collections.list(headers);
    }

    private static MimeMultipart getMimeMultipart(MimeMessage mimeMessage) throws MessagingException, IOException {
        String className = mimeMessage.getContent().getClass().getName();
        //System.out.println(className);
        if (className.equalsIgnoreCase("javax.mail.util.SharedByteArrayInputStream")) {
            SharedByteArrayInputStream sharedByteArrayInputStream = (SharedByteArrayInputStream) mimeMessage.getContent();
            return getMimeMultipartFromSharedByteArrayInputStream(sharedByteArrayInputStream);
        } else {
            throw new IOException("Invalid content type - getMimeMultipart");
        }
    }

    private static MessageStructureBean getPreamble(MimeMultipart outputMimeMultipart) throws MessagingException, JsonProcessingException {
        return readFromString(outputMimeMultipart.getPreamble(), MessageStructureBean.class);
    }

    private static <T> T readFromString(String content, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(content, clazz);
    }

    public static MimeMultipart getMimeMultipartFromSharedByteArrayInputStream(SharedByteArrayInputStream sharedByteArrayInputStream)
            throws MessagingException, IOException {
        ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
        return new MimeMultipart(dataSource);
    }

    public static MimeBodyPart getMimeBodyPartFromSharedByteArrayInputStream(SharedByteArrayInputStream sharedByteArrayInputStream)
            throws MessagingException, IOException {
        ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(new javax.activation.DataHandler(dataSource));
        return mimeBodyPart;
    }

    private static StreamedMultipartFooterResponse getFooter(Object object) throws IOException {
        String classname = object.getClass().getName();
        if(classname.equalsIgnoreCase("javax.mail.util.SharedByteArrayInputStream")) {
            SharedByteArrayInputStream sharedByteArrayInputStream = (SharedByteArrayInputStream) object;
            String footer = getStringFromStream(sharedByteArrayInputStream);
            return readFromString(footer, StreamedMultipartFooterResponse.class);
        }else{
            throw new IOException("Invalid content type.");
        }
    }

    public static String getStringFromStream(InputStream stream) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        while ((length = stream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8);
    }

    private static void assertMainHeaders(List<Header> inputHeadersList, Map<String, List<UnknownCharsetString>> parsedRFC822Headers) throws MessagingException {
        assert inputHeadersList.size() == parsedRFC822Headers.size();

        int index = 0;
        for (Map.Entry<String, List<UnknownCharsetString>> entry : parsedRFC822Headers.entrySet()) {
            assert inputHeadersList.get(index).getName().equalsIgnoreCase(entry.getKey());
            assert inputHeadersList.get(index).getValue().equalsIgnoreCase(entry.getValue().get(0).getValue());
            index++;
        }
    }

    private static void assertPartCount(MimeMessage input , MimeMultipart outputMimeMultipart) throws MessagingException, IOException {
        assert outputMimeMultipart.getCount() >=1;
        String className = input.getContent().getClass().getName();
        if(className.equalsIgnoreCase("java.lang.String")){
            if (outputMimeMultipart.getCount() - 1 != 1) {
                throw new IllegalStateException("Expected exactly one body part besides the footer.");
            }
        }else if(className.equalsIgnoreCase("javax.mail.internet.MimeMultipart")){
            MimeMultipart mimeMultipart = (MimeMultipart) input.getContent();
            if (outputMimeMultipart.getCount() - 1 != mimeMultipart.getCount()) {
                throw new IllegalStateException("Expected all body parts besides the footer.");
            }
        }else{
            throw new IOException("Empty Part Message"); // Need to check
        }
    }
}



/*

************************** MAIN HEADER VALIDATIONS ******************************
//        MessageStructureBean messageStructureBean = new MessageStructureBean();

//        List<Header> inputHeadersList = enumerationToList(getHeaders(input));
//        List<Header> outputHeadersList = enumerationToList(getHeaders(output));

//        System.out.println("Input Headers: ");
//        for (Header header : inputHeadersList) {
//            System.out.println(header.getName()+ " : " + header.getValue());
//        }
        /*
        Input Headers:
        Date : Tue, 26 Feb 2013 09:52:52 -0800 (PST)
        From : Test User<testuser@yahoo-inc.com>
        Reply-To : Test User <testuser@yahoo-inc.com>
        Subject : sample pdf
        To : "anothertester@yahoo.com" <anothertester@yahoo.com>
        MIME-Version : 1.0
        Content-Type : multipart/mixed; boundary="-1195379013-343248129-1361901172=:29394"
        Content-Length : 297469
         */

//        System.out.println("Output Headers: ");
//        for (Header header : outputHeadersList) {
//            System.out.println(header.getName()+ " : " + header.getValue());
//        }
        /*
        Output Headers:
        Boundary_1_1604154711_1721273443712 : Boundary_1_1604154711_1721273443712
        Content-Type : application/json
        Content-Disposition : form-data; name="MULTI_PART_HEADER"
         */

        /*
        System.out.println("Input Headers: " + inputHeadersList);
        System.out.println("Output Headers: " + outputHeadersList);

        Input Headers: [javax.mail.Header@34cd072c, javax.mail.Header@7a1ebcd8, javax.mail.Header@5faeada1, javax.mail.Header@528931cf, javax.mail.Header@ea1a8d5, javax.mail.Header@1563da5, javax.mail.Header@2bbf4b8b, javax.mail.Header@30a3107a]
        Output Headers: [javax.mail.Header@33c7e1bb, javax.mail.Header@34c4973, javax.mail.Header@52feb982]
         */

//        Assert.assertEquals(inputHeadersList, outputHeadersList);
//        Assert.assertEquals(inputHeadersList, outputHeadersList, "Headers does not match.");

