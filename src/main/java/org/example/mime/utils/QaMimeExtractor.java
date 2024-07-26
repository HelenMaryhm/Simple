package org.example.mime.utils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
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
}
