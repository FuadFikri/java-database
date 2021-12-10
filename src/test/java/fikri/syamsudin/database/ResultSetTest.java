package fikri.syamsudin.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {



    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getHikariDataSource().getConnection();
        Statement statement = connection.createStatement();


        String sql = "SELECT * FROM customer";

        ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println(
                        String.join("--",id.toString(),email,name)
                );
            }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
