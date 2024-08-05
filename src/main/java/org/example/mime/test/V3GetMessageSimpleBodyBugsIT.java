package org.example.mime.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.mime.beans.MessageStructureBean;
import org.example.mime.beans.StreamedMultipartFooterResponse;
import org.example.mime.utils.QaMimeExtractorScratchPad;
import org.example.mime.utils.QaMimeValidator;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.InputStream;


public final class V3GetMessageSimpleBodyBugsIT {

    private V3GetMessageSimpleBodyBugsIT(){

    }

    public static void testMimeWithEmptyPart() {
        // 01
    }

    public static void testGetMessageSimpleBodyWithTextDecorationAndBorderTag() {
        // 02
    }

    public static void testGetDisplayMessageforBug2759336() {
        // 03
    }

    public static void testGetDisplayMessageWhenContentIdNotReferenced() {
        // 04
    }

    public static void testGetDisplayMessageforTranscodingBadCharset() {
        // 05
    }

    public static void testGetDisplayMessageMAS28367() {
        // 06
    }

    public static void testGetDisplayMessageforBug7191625() {
        // 07
    }

    public static void testGetMessageSimpleBodyWithCSSFilterBypass() {
        // 08
    }

    public static void testCertifiedVidForYiv1() {
        // 09
    }

    public static void testGetDisplayMessageForJsonApp() {
        // 10
    }

    public static void testGetDisplayMessageforBug2858004() {
        // 11
    }

    public static void testGetDisplayMessageforInvalidCharacter() {
        // 12
    }

    public static void testCertifiedVidForYiv3() {
        // 13
    }

    public static void testGetDisplayMessageBug4259018() throws MessagingException, IOException {
        String inputFile = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/java/org/example/mime/resources/inlineImage.msg";
        String outputFile = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/java/org/example/mime/resources/inlinwImage-output.msg";

        MimeMessage input = QaMimeExtractorScratchPad.getMimeMessageFromFilePath(inputFile);
        MimeMessage output = QaMimeExtractorScratchPad.getMimeMessageFromFilePath(outputFile);

        QaMimeValidator.validateMimeMessage(input, output);

    }

    public static void testGDMLargeTextAttachment() throws MessagingException, IOException {

        String inputFile = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/resources/jedi/manual-scripts/01_V3GetMessageSimpleBodyAttachmentsIT/01_02_testGetMessageSimpleBodyWithInLineAttachmentsForce/Inbox1KB.msg";
        String outputFile = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/resources/jedi/manual-scripts/01_V3GetMessageSimpleBodyAttachmentsIT/01_02_testGetMessageSimpleBodyWithInLineAttachmentsForce/response-01.msg";

        MimeMessage input = QaMimeExtractorScratchPad.getMimeMessageFromFilePath(inputFile);
        MimeMessage output = QaMimeExtractorScratchPad.getMimeMessageFromFilePath(outputFile);

        QaMimeValidator.validateMimeMessage(input, output);
    }

    public static void testCertifiedVidForYiv2() throws MessagingException, IOException {
        // 16
        //String inputFilePath = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/java/org/example/mime/resources/testCertifiedVidForYiv1.msg";
        //String inputFilePathSingle = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/resources/jedi/manual-scripts/01_V3GetMessageSimpleBodyAttachmentsIT/01_02_testGetMessageSimpleBodyWithInLineAttachmentsForce/Inbox1KB.msg";

        //String inputFilePathPdf = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/java/org/example/mime/resources/msgWithPDF.msg";
        //String outputFilePathPdf = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/java/org/example/mime/resources/msgWithPDF-output.msg";

        String outputFilePathEmptyPart = "/Users/hmaryt/Documents/TYY/ML/Simple/src/main/resources/jedi/manual-scripts/04_V3GetMessageSimpleBodyBugsIT/01-testMimeWithEmptyPart/response-00001.msg";

        ObjectMapper objectMapper = new ObjectMapper();

        //MimeMessage input = QaMimeExtractorScratchPad.getMimeMessageFromFilePath(outputFilePathPdf);
        //MimeMessage output = QaMimeExtractorScratchPad.getMimeMessageFromFilePath(outputFilePathEmptyPart);
        InputStream inputStream = QaMimeExtractorScratchPad.getFileAsFileInputStream(outputFilePathEmptyPart);
        MimeMultipart mimeMultipart = QaMimeExtractorScratchPad.getMimeMultipartFromStream(inputStream);
        //MessageStructureBean messageStructureBean = QaMimeExtractor.getMessageStructureBean(mimeMultipart, objectMapper);
        //QaMimeExtractor.printStringFromClass(messageStructureBean, objectMapper);

        System.out.println(mimeMultipart.getCount());
        System.out.println("MessageStructureBean");

        try {
            MessageStructureBean messageStructureBean = objectMapper.readValue((InputStream) mimeMultipart.getBodyPart(0).getContent(), MessageStructureBean.class);
        } catch (IOException | MessagingException e) {
            throw new IllegalStateException("Error reading MessageStructureBean", e);
        }

        for (int i = 1; i < mimeMultipart.getCount()-1; i++) {

            System.out.println(mimeMultipart.getBodyPart(i).getContentType());

            System.out.println(QaMimeExtractorScratchPad.getStringFromStream((InputStream) mimeMultipart.getBodyPart(i).getContent()));
        }

        System.out.println("Footer");
        try {
            StreamedMultipartFooterResponse
                    streamedMultipartFooterResponse = objectMapper.readValue((InputStream) mimeMultipart.getBodyPart(mimeMultipart.getCount()-1).getContent(), StreamedMultipartFooterResponse.class);
        } catch (IOException | MessagingException e) {
            throw new IllegalStateException("Error reading MessageStructureBean", e);
        }
        //QaMimeExtractorScratchPad.printOutputMimeStructure(outputFilePathPdf);
        //QaMimeValidator.validateMimeMessage(input, output);

    }


}
