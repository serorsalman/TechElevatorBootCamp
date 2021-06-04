package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Department;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCDepartmentDAOTest {

    private static final String TEST_DEPARTMENT = "Seror Department";

    private static SingleConnectionDataSource dataSource;
    private JDBCDepartmentDAO dao;

    /* Before any tests are run, this method initializes the datasource for testing. */
    // this method runs once!
    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        //  MUST HAVE THIS in order to be able to rollback!
        dataSource.setAutoCommit(false);
    }

    /* After all tests have finished running, this method will close the DataSource */
    // this method runs once at the end - after last test is run
    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    /*
      run before any test methods run
     */
    @Before
    public void setup() {
        String sqlInsertDepartment = "INSERT INTO department ( name ) VALUES (?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT);

        dao = new JDBCDepartmentDAO(dataSource);

    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }


    @Test
    public void getAllDepartments() {
        //Arrange
        boolean departmentFound = false;
        List<Department> results = dao.getAllDepartments();

        //Act
        for (Department department : results) {
            if (department.getName().equals(TEST_DEPARTMENT)) {
                departmentFound = true;
            }

        }
        //Assert
        assertTrue(departmentFound);
    }

    @Test
    public void searchDepartmentsByName() {
        //Arrange
        Department theDepartment = getDepartment(TEST_DEPARTMENT);

        //ACT

        List<Department> results = dao.searchDepartmentsByName(TEST_DEPARTMENT);
        //Assert
        assertNotNull(results);  // making sure something is coming back
        assertEquals(1, results.size());  // should only have 1 city in the list
        Department saveDepartment = results.get(0);  // returns the city that was saved to the list
        assertEquals(theDepartment.getName(), saveDepartment.getName());
    }

    @Test
    public void saveDepartment() {
        List<Department> savedResults = dao.searchDepartmentsByName(TEST_DEPARTMENT);
        Department saveDep = savedResults.get(0);
        saveDep.setName("test department");

        dao.saveDepartment(saveDep);

        List<Department> results = dao.searchDepartmentsByName("test department");
        //Assert
        assertNotNull(results);  // making sure something is coming back
        assertEquals(1, results.size());  // should only have 1 city in the list
        Department saveDepartment = results.get(0);  // returns the city that was saved to the list
        assertEquals(saveDep.getId(), saveDepartment.getId());
        assertEquals(saveDep.getName(), saveDepartment.getName());
    }

    @Test
    public void createDepartment() {
        //create dep with some value
        //call it to check if what we created is there

        Department newDep = getDepartment("Tech");
        Department newDepartment = dao.createDepartment(newDep);
        boolean departmentFound = false;
        List<Department> results = dao.getAllDepartments();

        //Act
        for (Department department : results) {
            if (department.getName().equals("Tech")) {
                departmentFound = true;
            }

        }
        //Assert
        assertTrue(departmentFound);


    }

    @Test
    public void getDepartmentById() {
        // we need a valid value to test
        List<Department> departments = dao.getAllDepartments();
        Department first = departments.get(0);
        Department second = dao.getDepartmentById(first.getId());

        assertEquals(first.getName(), second.getName());
        assertEquals(first.getId(), second.getId());

    }

    private Department getDepartment(String name) {
        Department theDepartment = new Department();
        theDepartment.setName(name);
        return theDepartment;

    }
}