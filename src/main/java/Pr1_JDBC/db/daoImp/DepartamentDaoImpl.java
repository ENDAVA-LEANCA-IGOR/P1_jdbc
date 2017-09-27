package Pr1_JDBC.db.daoImp;

import Pr1_JDBC.db.dao.DepartamentDao;
import Pr1_JDBC.db.model.Departament;


import java.sql.*;

public class DepartamentDaoImpl implements DepartamentDao {
    private String userName = "postgres";
    private String password = "349InG167l";
    private String conectionUrl = "jdbc:postgresql://localhost:5432/BaseTest";

    public DepartamentDaoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Departament getById(Long id) {

        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTAMENT WHERE DEP_ID = " + id);
        ) {
            if (rs.next()) {
                Departament result = new Departament(rs.getLong("dep_id"),
                                                     rs.getString("dep_name"));
                return result;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
