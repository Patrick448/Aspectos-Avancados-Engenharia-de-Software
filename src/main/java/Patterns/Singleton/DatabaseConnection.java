package Patterns.Singleton;

public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();
    private String databaseUrl = "localhost:80";
    private String databasePassword = "123456";
    private DatabaseConnection(){

    }

    public static DatabaseConnection getInstance(){
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }
}
