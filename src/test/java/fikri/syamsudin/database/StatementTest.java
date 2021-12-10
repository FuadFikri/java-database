package fikri.syamsudin.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void testStatementInsert() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        Statement statement = connection.createStatement();


        String sql = "INSERT INTO customer(id,name,email) VALUES " +
                " ('1','FIKRI','fikri@mail.com')";

        int result = statement.executeUpdate(sql);
        System.out.println("jumlah record di database yang terkena impact dari sql diatas adalah : "+result);

        statement.close();

        connection.close();
    }

    @Test
    void testStatementSelect() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        Statement statement = connection.createStatement();


        String sql = "SELECT * FROM customer";

        ResultSet result = statement.executeQuery(sql);
        System.out.println(result);
        result.close();

        statement.close();

        connection.close();
    }
}
