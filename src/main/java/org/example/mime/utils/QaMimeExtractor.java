package org.example.mime.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.mime.beans.MessageStructureBean;
import org.example.mime.beans.MessageStructurePart;
import org.example.mime.beans.StreamedMultipartFooterResponse;

import javax.annotation.Nonnull;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.mail.util.SharedByteArrayInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public final class QaMimeExtractor {

    private QaMimeExtractor() {

    }

    public static MimeMessage getMimeMessage(InputStream is) throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.mime.address.strict", "false");
        Session session = Session.getInstance(props);
        return new MimeMessage(session, is);
    }

    public static MimeMessage getMimeMessageFromString(String response) throws MessagingException {
        InputStream is = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
        return getMimeMessage(is);
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

    public static MessageStructureBean getMessageStructureBean(MimeMultipart outputMimeMultipart, @Nonnull ObjectMapper objectMapper)
            throws MessagingException, JsonProcessingException {
        return readFromString(outputMimeMultipart.getPreamble(), MessageStructureBean.class, objectMapper);
    }

    public static <T> T readFromString(String content, Class<T> clazz, @Nonnull ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.readValue(content, clazz);
    }

    public static MimeMultipart getMimeMultipartFromSharedByteArrayInputStream(SharedByteArrayInputStream sharedByteArrayInputStream)
            throws MessagingException, IOException {
        ByteArrayDataSource dataSource = new ByteArrayDataSource(sharedByteArrayInputStream, "application/octet-stream");
        return new MimeMultipart(dataSource);
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

    public static StreamedMultipartFooterResponse getFooter(Object object, @Nonnull ObjectMapper objectMapper) throws IOException {
        String classname = object.getClass().getName();
        if (("javax.mail.util.SharedByteArrayInputStream").equalsIgnoreCase(classname)) {
            SharedByteArrayInputStream sharedByteArrayInputStream = (SharedByteArrayInputStream) object;
            String footer = QaMimeExtractor.getStringFromStream(sharedByteArrayInputStream);
            return QaMimeExtractor.readFromString(footer, StreamedMultipartFooterResponse.class, objectMapper);
        } else {
            throw new IOException("Invalid content type.");
        }
    }

    public static int getPartCountInResponse(MessageStructurePart messageStructurePart) {
        return messageStructurePart.getDocTree().getParts().size();
    }

    public static void printStringFromClass(MessageStructureBean messageStructureBean, @Nonnull final ObjectMapper objectMapper) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(messageStructureBean);
        System.out.println(jsonString);
    }


//    public static MessageStructureBean getMessageStructureBeanFromYaml(List<YamlFileToApiResponseReader.PartData> getPartDataList,
//                                                                       @Nonnull final ObjectMapper objectMapper) {
//        return getPartDataList.stream()
//                .filter(x -> ("MULTI_PART_HEADER").equals(x.getName()))
//                .findFirst()
//                .map(part -> {
//                    try {
//                        return QaMimeExtractor.readFromString(part.getData(), MessageStructureBean.class, objectMapper);
//                    } catch (JsonProcessingException e) {
//                        throw new IllegalArgumentException("Invalid JSON data for MULTI_PART_HEADER", e);
//                    }
//                })
//                .orElseThrow(() -> new NoSuchElementException("MULTI_PART_HEADER not found"));
//    }
}
