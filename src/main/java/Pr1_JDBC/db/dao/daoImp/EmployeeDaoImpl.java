package Pr1_JDBC.db.dao.daoImp;

import Pr1_JDBC.db.dao.EmployeeDao;
import Pr1_JDBC.db.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private String userName = "postgres";
    private String password = "349InG167l";
    private String conectionUrl = "jdbc:postgresql://localhost:5432/BaseTest";

    public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Employee getById(Long id) {

        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = " + id);
        ) {
            if (rs.next()) {
                Employee result = new Employee(rs.getLong("emp_id"), rs.getString("f_name"), rs.getString("l_name"));
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
    public boolean update(Employee employee) {
        int numberOfUpdates;
        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                PreparedStatement preparedStatement = conn.prepareStatement("UPDATE EMPLOYEE SET F_NAME=?, L_NAME = ? WHERE EMP_ID=?");
        ) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setLong(3, employee.getEmployeeId());
            numberOfUpdates = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return numberOfUpdates > 0;
    }

    @Override
    public boolean delete(Long employeeId) {
        int numberOfDeletes;
        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                PreparedStatement preparedStatement = conn.prepareStatement("DELETE EMPLOYEE  WHERE EMP_ID=?");
        ) {
            preparedStatement.setLong(1, employeeId);
            numberOfDeletes = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return numberOfDeletes > 0;
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        try (
                Connection conn = DriverManager.getConnection(conectionUrl, userName, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE F_NAME = '" + firstName + "'");
        ) {
            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee(rs.getLong("emp_id"), rs.getString("f_name"), rs.getString("l_name"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
