package Pr1_JDBC.db;

import Pr1_JDBC.db.dao.EmployeeDao;
import Pr1_JDBC.db.daoImp.EmployeeDaoImpl;
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
        Employee result = employeeDao.getById(2L);

        assertNotNull(result);
        assertEquals("Ion", result.getFirstName());
        assertEquals("Mare", result.getLastName());
    }

    @Test
    public void shouldReturnNullIfNoPresentInDatabase() {
        Employee result = employeeDao.getById(999L);

        assertNull(result);
    }

    @Test
    public void shouldReturnListOfEmployees() {
        List<Employee> byFirstName = employeeDao.getByFirstName("Paul");

        assertEquals(2, byFirstName.size());
        byFirstName.forEach(emp ->
                assertEquals("Paul", emp.getFirstName())
        );
    }

    @Test
    public void shouldReturnemptyListif(){
        List<Employee> byFirstName = employeeDao.getByFirstName("ion1");

        assertEquals(0,byFirstName.size());
    }
}
