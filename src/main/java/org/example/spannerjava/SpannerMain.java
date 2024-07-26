package org.example.spannerjava;

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;

public class SpannerMain {

    public static String projectId;
    public static String instanceId;
    public static String dbName;

    public static Statement statement = Statement.of("select count(*) from label");

    public static void main(String[] args) {
        CreateDatabaseClient createDatabaseClient = new CreateDatabaseClient();
        try (ResultSet resultSet = createDatabaseClient.getDatabaseClient().singleUse().executeQuery(statement)) {
            while (resultSet.next()){
                System.out.println("TYY");
                System.out.println(resultSet.getLong(0)); //73
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }finally {
            createDatabaseClient.closeDBConnectionOwnMethod();
        }
    }
    
}
    