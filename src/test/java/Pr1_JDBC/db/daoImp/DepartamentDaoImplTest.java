package Pr1_JDBC.db.daoImp;

import Pr1_JDBC.db.model.Departament;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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