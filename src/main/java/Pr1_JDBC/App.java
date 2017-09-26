package Pr1_JDBC;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;

public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException , IOException, ClassNotFoundException {
        String userName = "postgres";
        String password = "349InG167l";
        String conectionUrl = "jdbc:postgresql://localhost:5432/BaseTest";
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(conectionUrl,userName,password);
            System.out.println("Opened database successfully");
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
}
