package Pr1_JDBC.db.dao;

import Pr1_JDBC.db.model.Salary;

public interface SalaryDao {
    Salary getById(Long id);
}
