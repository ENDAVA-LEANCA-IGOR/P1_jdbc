package Pr1_JDBC.db.daoImp;

import Pr1_JDBC.db.dao.DepartamentDao;
import Pr1_JDBC.db.model.Departament;

import java.sql.SQLException;

public class DepartamentDaoImpl implements DepartamentDao {
    private String userName = "postgres";
    private String password = "349InG167l";
    private String conectionUrl = "jdbc:postgresql://localhost:5432/BaseTest";

    public DepartamentDaoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Departament getById(Long id) {
        return null;
    }
}
