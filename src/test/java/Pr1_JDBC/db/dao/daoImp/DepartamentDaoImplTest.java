package Pr1_JDBC.db.dao.daoImp;

import org.junit.Before;
import org.junit.Test;

public class DepartamentDaoImplTest {

    DepartamentDaoImpl departament;

    @Before
    public void setUp() throws Exception {
        departament = new DepartamentDaoImpl();

    }

    @Test
    public void getById() throws Exception {
        departament.getById(2l);

    }

}