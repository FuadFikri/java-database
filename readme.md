

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

