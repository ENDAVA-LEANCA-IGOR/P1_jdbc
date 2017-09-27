package Pr1_JDBC.db.dao;

import Pr1_JDBC.db.model.Manager;

public interface ManagerDao {
    Manager getById(Long id);
}
