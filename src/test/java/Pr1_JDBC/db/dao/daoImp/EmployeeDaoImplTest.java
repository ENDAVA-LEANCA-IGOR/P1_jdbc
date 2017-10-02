package Pr1_JDBC.db.dao.daoImp;

import Pr1_JDBC.db.dao.EmployeeDao;
import Pr1_JDBC.db.dao.daoImp.EmployeeDaoImpl;
import Pr1_JDBC.db.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoImplTest {

    private EmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    public void shouldReturnEmployeeById() {
        // Arrange
        Employee result = employeeDao.getById(2L);

        // Act

        // Assert
        assertNotNull(result);
        assertEquals("Ion", result.getFirstName());
        assertEquals("Mare", result.getLastName());
    }

    @Test
    public void shouldReturnNullIfNoPresentInDatabase() {
        // Arrange
        Employee result = employeeDao.getById(999L);

        // Act

        // Assert
        assertNull(result);
    }

    @Test
    public void shouldReturnListOfEmployees() {
        // Arrange
        List<Employee> byFirstName = employeeDao.getByFirstName("Paul");

        // Act

        // Assert
        assertEquals(2, byFirstName.size());
        byFirstName.forEach(emp ->
                assertEquals("Paul", emp.getFirstName())
        );
    }

    @Test
    public void shouldReturnemptyListif(){
        // Arrange

        // Act
        List<Employee> byFirstName = employeeDao.getByFirstName("ion1");

        // Assert
        assertEquals(0,byFirstName.size());
    }
    @Test
    public void shouldReturnTrueUpdate(){
        // Arrange
        Employee byId = employeeDao.getById(1L);

        // Act
        System.out.println(byId);
        byId.setFirstName("Vasile1");
        employeeDao.update(byId);
        System.out.println(byId);
        Employee updated = employeeDao.getById(1L);

        // Assert
        assertEquals("Vasile1", updated.getFirstName());

    }


}
