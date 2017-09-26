package Pr1_JDBC.db.Dao;

import Pr1_JDBC.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getById(Long id);

    List<Employee> getByFirstName(String firstName);

    boolean save(Employee employee);

    boolean update(Employee employee);

    boolean delete(Long employeeId);
}
