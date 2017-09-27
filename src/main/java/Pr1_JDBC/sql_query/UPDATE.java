package Pr1_JDBC.sql_query;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class UPDATE
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
            String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
            stmt.executeUpdate(sql);
            connection.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
}