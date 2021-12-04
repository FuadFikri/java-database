package fikri.syamsudin.database;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


    @BeforeAll
    static void beforeAll(){
        try {
            Driver driver = new Driver();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void testConnection(){
        String jdbcURL = "jdbc:mysql://localhost:3306/java_database";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("sukses membuat connection ke database !");
        } catch (SQLException throwables) {
            Assertions.fail(throwables);
        }
    }

    @Test
    void testConnectionClose(){
        String jdbcURL = "jdbc:mysql://localhost:3306/java_database";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("sukses membuat connection ke database !");

            connection.close();
            System.out.println("sukses menutup connection ke database !");
        } catch (SQLException throwables) {
            Assertions.fail(throwables);
        }
    }
}
