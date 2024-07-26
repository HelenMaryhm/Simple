package org.example.spannerjava;

import com.google.auth.oauth2.GoogleCredentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class GcloudAuthenticate {

    private static String GOOGLE_APPLICATION_CREDENTIALS="/Users/hmaryt/.athenz/gcp/cfg-mail.core.data.d-api-poc-gcp.fed.power.user.json";

    public static GoogleCredentials getCredentials(){

        File file = new File(String.valueOf(Path.of("/Users/hmaryt/.athenz/gcp/cfg-mail.core.data.d-api-poc-gcp.fed.power.user.json")));

        try(FileInputStream fileInputStream = new FileInputStream(file)){
            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(fileInputStream);
            return googleCredentials;
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
