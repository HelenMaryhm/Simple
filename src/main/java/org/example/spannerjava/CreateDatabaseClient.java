package org.example.spannerjava;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;

public class CreateDatabaseClient {

    private DatabaseAdminClient databaseAdminClient = null;
    private DatabaseClient databaseClient = null;
    private Spanner spanner = null;

    public CreateDatabaseClient() {
        createDatabaseAdminClient();
    }

    public DatabaseAdminClient getDatabaseAdminClient() {
        return databaseAdminClient;
    }

    public DatabaseClient getDatabaseClient() {
        return databaseClient;
    }

    private void createDatabaseAdminClient() {
        String projectId = "gcp-mail-core-data-d-api-poc";
        String instanceId = "cm-dev-custom-sandbox";
        String databaseName = "hmaryt-db";

        SpannerOptions spannerOptions = SpannerOptions.newBuilder().setCredentials(GcloudAuthenticate.getCredentials())
                .setProjectId(projectId).build();
        spanner = spannerOptions.getService();

        try {
            DatabaseId databaseId = DatabaseId.of(projectId, instanceId, databaseName);
            databaseClient = spanner.getDatabaseClient(databaseId);
            databaseAdminClient = spanner.createDatabaseAdminClient();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeDBConnectionOwnMethod() {
        if (databaseAdminClient != null) {
            if (!databaseAdminClient.isShutdown() || !databaseAdminClient.isTerminated()) {
                databaseAdminClient.close();
            }
        }
        spanner.close();
    }
}