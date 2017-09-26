package Pr1_JDBC;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class INSERT
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, ClassNotFoundException {
        String userName = "postgres";
        String password = "349InG167l";
        String conectionUrl = "jdbc:postgresql://localhost:5432/BaseTest";
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(conectionUrl,userName,password);
            System.out.println("Opened database successfully");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "INSERT INTO employee (f_name,l_name,manag_idf,salary_idf) "
                    + "VALUES ('Paul', 'Gheorghiu', 1, 2 );";
            stmt.executeUpdate(sql);


            sql = "INSERT INTO employee (f_name,l_name,manag_idf,salary_idf) "
                    + "VALUES ('Paul1', 'Gheorghiu2', 1, 1 );";
            stmt.executeUpdate(sql);


            stmt.close();
            connection.commit();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
}