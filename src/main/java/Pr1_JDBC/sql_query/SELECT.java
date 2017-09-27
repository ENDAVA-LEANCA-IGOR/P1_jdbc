package Pr1_JDBC.sql_query;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class SELECT
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
            ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
            while ( rs.next() ) {
                int emp_id = rs.getInt("emp_id");
                String  f_name = rs.getString("f_name");
                String l_name  = rs.getString("l_name");
                int  manag_idf = rs.getInt("manag_idf");
                int salary_idf = rs.getInt("salary_idf");
                System.out.println( "ID = " + emp_id );
                System.out.println( "f_name = " + f_name );
                System.out.println( "l_name = " + l_name );
                System.out.println( "manag_idf = " + manag_idf );
                System.out.println( "salary_idf = " + salary_idf );
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