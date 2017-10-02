package Pr1_JDBC.db.dao;

import Pr1_JDBC.db.model.Employee;
import Pr1_JDBC.db.model.Manager;

public interface ManagerDao {

    public Manager getById(Long id);

    boolean update(Manager manager);

    boolean delete(Long manager_id);
}
