package Pr1_JDBC.db.dao.daoImp;

import Pr1_JDBC.db.dao.EmployeeDao;
import Pr1_JDBC.db.dao.ManagerDao;
import Pr1_JDBC.db.model.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDaoImplTest1 {

    private EmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    public void getByIdTest() throws Exception {
        // Arrange
        Employee result = employeeDao.getById(3L);

        // Act

        // Assert
        assertNotNull(result);
        assertEquals("Gheorghe ", result.getFirstName());
        assertEquals("Stefanet", result.getLastName());
    }

    @Test
    public void updateTest() throws Exception {
        // Arrange



        // Act

        // Assert
        assertTrue();
    }

    @Test
    public void deleteTest() throws Exception {
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void getByFirstNameTest() throws Exception {
        // Arrange

        // Act

        // Assert
    }

}