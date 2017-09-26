package Pr1_JDBC.db.DaoImp;

import Pr1_JDBC.db.Dao.EmployeeDao;
import Pr1_JDBC.model.Employee;
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

    @Override
    public boolean save(Employee employee) {

        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Long employeeId) {
        return false;
    }
}
