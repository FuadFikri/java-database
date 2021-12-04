package fikri.syamsudin.database;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {


// Register driver
    @Test
    void testRegister(){
        try {
            Driver mysqlDriver = new Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException throwables) {
            Assertions.fail(throwables);
            throwables.printStackTrace();
        }
    }
}
