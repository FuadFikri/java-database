package fikri.syamsudin.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {


    @Test
    void testCommit() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO customer(name,email) VALUES " +
                " (?, ?)";


        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "fuads");
            preparedStatement.setString(2, "fik27s9@mail.com");
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }

        connection.commit();

        connection.close();
    }



    @Test
    void testRollback() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO customer(name,email) VALUES " +
                " (?, ?)";


        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "fuads");
            preparedStatement.setString(2, "fik27s9@mail.com");
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }

        connection.rollback();
        connection.close();
    }
}
