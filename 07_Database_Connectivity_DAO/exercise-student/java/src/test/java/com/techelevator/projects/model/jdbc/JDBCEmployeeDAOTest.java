package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Employee;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCEmployeeDAOTest {
    private static final String TEST_DEPARTMENT = "Seror Department";
    private static final String TEST_FIRST_NAME = "Raya";
    private static final String TEST_LAST_NAME = "SAL";
    private static final String TEST_GENDER = "F";
    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private JDBCEmployeeDAO testEmployee;
    int preSize = 0;
    private static final String TEST_PROJECT= "ROBLOX";



    private static SingleConnectionDataSource dataSource;
    private JDBCDepartmentDAO testDepartment;

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
    public void setup() throws ParseException {
        //instantiate so we can call them
        testDepartment = new JDBCDepartmentDAO(dataSource); // dao is the name
        testEmployee = new JDBCEmployeeDAO(dataSource);

        String sqlInsertProject= "INSERT INTO project (name) VALUES (?)";

        //getting the size of the employee
        List<Employee> preEmployeeSize = testEmployee.getAllEmployees();
        preSize = preEmployeeSize.size();

        Date bDate = formatter.parse("1986-06-06");
        Date hDate = formatter.parse("2006-06-06");

        String sqlInsertDepartment = "INSERT INTO department (department_id,  name ) VALUES (1000, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertProject, TEST_PROJECT);
        jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT);

        String sqlInsertEmployee = "INSERT INTO employee ( department_id, first_name, last_name,birth_date, gender, hire_date) " +
                "VALUES ( 1000 , ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertEmployee, TEST_FIRST_NAME, TEST_LAST_NAME, bDate, TEST_GENDER, hDate);


    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void getAllEmployees() {
        List<Employee> results = testEmployee.getAllEmployees();
        int actual = results.size();
        int expected = preSize + 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchEmployeesByName() {

        List<Employee> employeeListResults = testEmployee.searchEmployeesByName(TEST_FIRST_NAME, TEST_LAST_NAME);

        Assert.assertEquals(1, employeeListResults.size());
    }

    @Test
    public void getEmployeesByDepartmentId() {
        List<Employee> empDepId = testEmployee.getEmployeesByDepartmentId(1000);
        Assert.assertEquals(1, empDepId.size());
    }

    @Test
    public void getEmployeesWithoutProjects() {
        List<Employee> employeeList = testEmployee.getEmployeesWithoutProjects();
        String actual = employeeList.get(employeeList.size()-1).getFirstName();

        Assert.assertEquals(TEST_FIRST_NAME, actual);



    }

    @Test
    public void getEmployeesByProjectId() {
        String sqlEmployee_id = "SELECT employee_id FROM employee WHERE first_name = ?";
        String sqlProjectId= "SELECT project_id FROM project WHERE name = ?";
        String sqlInsertProject = "INSERT INTO project_employee (project_id, employee_id ) VALUES " +
                "(?, ? )";

        //jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SqlRowSet projectFinder = jdbcTemplate.queryForRowSet(sqlProjectId, TEST_PROJECT);
        projectFinder.next();
        Long test_project_id= projectFinder.getLong("project_id");
        SqlRowSet employeeFinder = jdbcTemplate.queryForRowSet(sqlEmployee_id, TEST_FIRST_NAME);

        employeeFinder.next();
        Long test_employee_id= employeeFinder.getLong("employee_id");

        jdbcTemplate.update(sqlInsertProject, test_project_id, test_employee_id);

        List<Employee> empProject = testEmployee.getEmployeesByProjectId(test_project_id);
        String actual= empProject.get(empProject.size()-1).getFirstName();
        Assert.assertEquals(TEST_FIRST_NAME, actual);


    }

    @Test
    public void changeEmployeeDepartment() {
        String sqlEmployee_id = "SELECT employee_id FROM employee WHERE first_name = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SqlRowSet employeeFinder = jdbcTemplate.queryForRowSet(sqlEmployee_id, TEST_FIRST_NAME);

        employeeFinder.next();
        Long test_employee_id= employeeFinder.getLong("employee_id");
        testEmployee.changeEmployeeDepartment(test_employee_id, 1l);

        List<Employee> employeeList= testEmployee.getEmployeesByDepartmentId(1000l);

        Assert.assertEquals(0, employeeList.size());


    }

}