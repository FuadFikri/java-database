package fikri.syamsudin.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

    @Test
    void batchInStatement() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO customer(name,email) VALUES " +
                " ('FIKRI','fikri@mail.com')";

        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }

        statement.executeBatch();
        statement.close();
        connection.close();
    }


    @Test
    void batchInPrepared() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        String sql = "INSERT INTO customer(name,email) VALUES " +
                " (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        for (int i = 0; i < 1000; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "fuad");
            preparedStatement.setString(2,"fik279@mail.com");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }
}
