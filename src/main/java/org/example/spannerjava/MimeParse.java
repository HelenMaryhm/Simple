package org.example.spannerjava;

import javax.mail.Header;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MimeParse {

    private static ByteArrayInputStream byteArrayInputStream;
    private static String content;

    /*
    1. Read the content of the file by using the fileToInputStream method.
    2. Set the class variable.
    3. Mark the stream 0 and reset it once read.
    4. Extract the boundary from the content.
    5. Validate the email headers.
    6. Get All the parts.
    7. Validate each parts.

     */

    public static ByteArrayInputStream fileToInputStream(String filePath) throws IOException {
        byte[] fileContent = Files.readAllBytes(Path.of(filePath));
        return new ByteArrayInputStream(fileContent);
    }

    public static void setData(String filePath) throws IOException {
        byteArrayInputStream = fileToInputStream(filePath);
        content = new String(byteArrayInputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    public static String extractBoundary() {
        Pattern pattern = Pattern.compile("boundary=\"([^\"]+)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String[] getParts(String boundary) {
        String boundaryRegex = "--" + Pattern.quote(boundary);
        Pattern pattern = Pattern.compile(boundaryRegex, Pattern.MULTILINE);
        return pattern.split(content);
    }

    public static void validateEachParts(String[] parts) throws Exception {
        if(parts.length>1){
            validateEmailHeaders(parts[0]); //main message headers
            int bodyParts = parts.length - 1;
            for (int i = 1; i <= bodyParts; i++) {
                /*

                1. Scan the content.
                2. Split based on next line. Previous is headers and next is body.
                3. Check in headers if boundary is there. If yes, then it is a multipart. Do multipart validation.
                4. If no boundary, then it is a single part. Do single part validation.

                MULTIPART VALIDATION:
                1. Extract the boundary.
                2. Get all parts.
                3. Part[0] is main message headers. Validate it.
                4. ArrayList<String[]> parts = ArrayList of headers and body.






                validate headers
                validate body

                upto empty line is headers.

                Possible options:
                1. Boundary can be present or not.
                2. style2: If boundary is present, then it can have multiple parts.
                3. style1: If no boundary, then it is a single part.

                style1:
                1. validate headers
                2. validate body

                content-types:
                1. text/plain
                2. text/html
                3. multipart/alternative
                4. multipart/mixed
                5. multipart/related
                6. multipart/signed
                7. multipart/encrypted
                8. message/rfc822


                style2:

                 */

                int partCount = 0;



                String boundary = extractBoundary();
                if(boundary!=null){
                    String[] internalParts = getParts(boundary);
                    validateEachParts(parts);
                    checkMimeMessage(parts[i], boundary);
                }
            }
        }
    }

    public static void validateParts(){

    }

    public static List<String[]> getHeadersAndParts(String data, String boundary){
        List<String[]> parsedParts = new ArrayList<>();

        Scanner scanner = new Scanner(data);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(boundary)) {
                String headers = "";
                String body = "";
                boolean isHeader = true;
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (line.isEmpty()) {
                        isHeader = false;
                    } else if (isHeader) {
                        headers += line + "\n";
                    } else {
                        body += line + "\n";
                    }
                    if (line.contains(boundary)) {
                        break;
                    }
                }
                parsedParts.add(new String[]{headers.trim(), body.trim()});
            }
        }
        scanner.close();
        return parsedParts;
    }


    public static void validateEmailHeaders(String emailHeaders) throws Exception {

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

    public static void checkMimeMessage(String mimeMessage, String boundary){
        List<String[]> parts = getHeadersAndParts(mimeMessage, boundary);
        System.out.println("Number of parts: " + parts.size());
        for (String[] part : parts) {
            System.out.println();
            System.out.println("********* HEADER *********");
            System.out.println(part[0]);
            System.out.println();
            System.out.println();
            System.out.println("********* BODY *********");
            System.out.println(part[1]);
            System.out.println();
            System.out.println();
            System.out.println("**************************");
        }
    }




    public static void main(String[] args) throws Exception {
        String filePath = "/Users/hmaryt/Documents/TYJ/jedi/apps/qa/qa_common/src/main/resources/com/yahoo/mail/qa/messages/msgWithTnefWithAttachments.msg";
        setData(filePath);
        String boundary = extractBoundary();
        String[] parts = getParts(boundary);
        validateEachParts(parts);
    }

}
