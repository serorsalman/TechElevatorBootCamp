package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCProjectDAO implements ProjectDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCProjectDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Project> getAllActiveProjects() {
        List<Project> projectList = new ArrayList<>();
        String sqlGetAllActiveProjects = "SELECT project_id, name, from_date, to_date FROM project WHERE " +
                "(now() BETWEEN from_date AND to_date) OR " + "(now() > from_date AND to_date IS NULL) OR "
                + "(now() < to_date AND from_date IS NULL)";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllActiveProjects);
        while (results.next()) {
            Project theProject = mapRowToProject(results);
            projectList.add(theProject);
        }
        return projectList;
    }

    @Override
    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        String sqlRemove = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
        jdbcTemplate.update(sqlRemove, projectId, employeeId);

    }

    @Override
    public void addEmployeeToProject(Long projectId, Long employeeId) {
        String sqlInsert = " INSERT INTO project_employee ( project_id, employee_id) " +
                "VALUES (( SELECT project_id FROM project WHERE project_id = ?), " +
                "(SELECT employee_id FROM employee WHERE employee_id = ?))";

        jdbcTemplate.update(sqlInsert, projectId, employeeId);

    }

    private Project mapRowToProject(SqlRowSet results) {
        Project theProject = new Project();
        Long id = results.getLong("project_id");
        String name = results.getString("name");

        theProject.setId(id);
        theProject.setName(name);
        return theProject;
    }

}
