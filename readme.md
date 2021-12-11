# Belajar Java Database
      sumber : Programmer Zaman Now

### Driver
Penghubung antara JDBC dengan DBMS.
Driver berisi class-class implementasi dari JDBC

### Mysql Driver
 Menambah dependency mysql-connector-java

### Connection
- Direpresentasikan pada interface java.sql.Connection
- Untuk membuat connection ke database, bisa menggunakan method getConnection pada DriverManager

### Connection Pool
- Membuat conection terlebih dahulu diawal dibandingkan dengan membuat koneksi baru ke dataabase setiap ada request datang.
- Connection Pool di JDBC direpresentasikan javax.sql.DataSource
- Library yang paling bagus yaitu HikariCP


### Statement
 - java.sql.Statement
 - Untuk mengirim sql ke database
 - untuk membuat statement bisa menggunakan method createStatement() pada connection.

    #### statement.executeUpdate(sql)
        - digunakan untuk mengirim perintah sql INSERT, UPDATE DELETE yang tidak membutuhkan balikan.
        - return int, yaitu jumlah data yang terkena impact dari sql yang dieksekusi

    #### statement.executeQuery(sql)
        - digunakan untuk perintah sql yang mengembalikan data.
        - return ResultSet

### ResultSet
    - adalah representasi data hasil query dari database
    - Cara kerjanya seperti cursor, untuk maju menggunakan next() dan untuk mundur gunakan previous()
         
         while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
            }


### PreparedStatement
   - Turunan dari interfce Statement
   - PreparedStatement memiliki kemampuan mengamankan input dari user sehingga aman dari sql injection


### Database Transaction
   -  Secara default, Connection yang dibuat dengan JDBC memiliki sifat auto commit.
   - Untuk melakukan database transaction, kita membutuhkan commit setelah semua proses selesai, maka kita perlu mematikan auto commit di JDBC.

         

