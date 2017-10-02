package Pr1_JDBC.db.dao.daoImp;

import Pr1_JDBC.db.dao.ManagerDao;
import Pr1_JDBC.db.model.Employee;
import Pr1_JDBC.db.model.Manager;

import java.sql.*;

public class ManagerDaoImpl implements ManagerDao {
    private String userName = "postgres";
    private String password = "postgres";
    private String conectionUrl = "jdbc:postgresql://localhost:5432/BaseTest";

    public ManagerDaoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Manager getById(Long id) {

        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manager WHERE mang_id = " + id);
        ) {
            if (rs.next()) {
                Manager result = new Manager(rs.getLong("mang_id"),rs.getLong("departament_id"),rs.getString("f_name"),rs.getString("l_name"));
                return result;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Manager manager) {
        int numberOfUpdates;
        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                PreparedStatement preparedStatement = conn.prepareStatement("UPDATE manager SET F_NAME=?, L_NAME = ? WHERE mang_id=?");
        ) {
            preparedStatement.setString(1, manager.getF_name());
            preparedStatement.setString(2, manager.getL_name());
            preparedStatement.setLong(3, manager.getManager_id());
            numberOfUpdates = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return numberOfUpdates > 0;
    }

    @Override
    public boolean delete(Long manager_id) {
        int numberOfDeletes;
        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                PreparedStatement preparedStatement = conn.prepareStatement("DELETE manager  WHERE mang_id=?");
        ) {
            preparedStatement.setLong(1, manager_id);
            numberOfDeletes = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return numberOfDeletes > 0;
    }
}
