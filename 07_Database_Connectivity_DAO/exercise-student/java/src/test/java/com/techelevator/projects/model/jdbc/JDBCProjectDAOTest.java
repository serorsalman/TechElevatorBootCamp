package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Project;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCProjectDAOTest {
    private static SingleConnectionDataSource dataSource;
    private JDBCProjectDAO dao;
    private JDBCEmployeeDAO daoEmployee;
    private static final String TEST_PROJECT = "Roblox";
    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }
    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }
    @Before
    public void setup() {
        Date from_date = Date.valueOf("2016-08-08");
        Date to_date = Date.valueOf("2019-08-08");
        String sqlInsertProject = "INSERT INTO project (project_id, name, from_date, to_date) Values(100, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertProject, TEST_PROJECT, from_date, to_date);
        dao = new JDBCProjectDAO(dataSource);
        daoEmployee = new JDBCEmployeeDAO(dataSource);
    }
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }
    @Test
    public void testGetAllActiveProjects() {
        List<Project> results = dao.getAllActiveProjects();
        Assert.assertNotNull(results);
        Assert.assertEquals(1, results.size());
        Assert.assertEquals("The Never-ending Project", results.get(0).getName());
    }
    @Test
    public void testAddAndRemoveEmployeeFromProject() {
        Long employeeID = daoEmployee.getAllEmployees().get(7).getId();
        Long projectID = dao.getAllActiveProjects().get(0).getId();
        int numBeforeAddingEmployee = daoEmployee.getEmployeesByProjectId(projectID).size();
        dao.addEmployeeToProject (projectID, employeeID);


        Assert.assertEquals(numBeforeAddingEmployee + 1 , daoEmployee.getEmployeesByProjectId(projectID).size());
        dao.removeEmployeeFromProject(projectID, employeeID);
        Assert.assertEquals(numBeforeAddingEmployee , daoEmployee.getEmployeesByProjectId(projectID).size());
    }
}