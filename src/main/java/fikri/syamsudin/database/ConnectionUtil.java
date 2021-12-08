package fikri.syamsudin.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        config.setJdbcUrl("jdbc:mysql://localhost:3306/java_database");
        config.setUsername("root");
        config.setPassword("root");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setMaxLifetime(10 * 60_000);
        config.setConnectionTimeout(10_000);

        hikariDataSource = new HikariDataSource(config);
    }


    public static HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
