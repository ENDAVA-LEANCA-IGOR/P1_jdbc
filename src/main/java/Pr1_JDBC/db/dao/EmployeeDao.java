package Pr1_JDBC.db.dao;

import Pr1_JDBC.db.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee getById(Long id);

    List<Employee> getByFirstName(String firstName);

    boolean save(Employee employee);

    boolean update(Employee employee);

    boolean delete(Long employeeId);
}
