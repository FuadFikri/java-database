package fikri.syamsudin.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {


    @Test
    void hikariCPTest(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        config.setJdbcUrl("jdbc:mysql://localhost:3306/java_database");
        config.setUsername("root");
        config.setPassword("root");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setMaxLifetime(10 * 60_000);
        config.setConnectionTimeout(10_000);

        HikariDataSource dataSource = new HikariDataSource(config);
        try {
            Connection connection = dataSource.getConnection();

            connection.close(); // mengembalikan connection datasource HikariCP

            dataSource.close(); // close semua koneksi didalam connection pool

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Assertions.fail(throwables);

        }

    }

    @Test
    void testUtil() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        Assertions.assertNotNull(connection);
    }
}
