package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCDepartmentDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // @override means we are providing the body to the abstract method in the interface
    public List<Department> getAllDepartments() {
        //create java list to hold all the rows of department objects coming from the DB
        List<Department> departmentList = new ArrayList<>(); //department list , is the name for the varible

        // write our sql statement as string
        String sqlGetAllDepartments = " SELECT department_id, name FROM department"; // call what is in the database

        //call the jdbcTemplate.queryForRowSet which returns the rows from the db
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);

        // loop through the rows
        while (results.next()) {
            // create new java object for each row that maps the db info to ajava department object
            Department theDepartment = mapRowToDepartment(results);

            // add the java department object to our list
            departmentList.add(theDepartment);
        }
        return departmentList;
    }

    @Override
    public List<Department> searchDepartmentsByName(String nameSearch) {
        List<Department> departmentList = new ArrayList<>();
        String sqlSearchDepartmentByName = "SELECT department_id, name FROM department WHERE name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartmentByName, nameSearch);
        while (results.next()) {
            Department theDepartment = mapRowToDepartment(results);
            departmentList.add(theDepartment);
        }

        return departmentList;
    }


    @Override
    public void saveDepartment(Department updatedDepartment) {
        String sqlUpdate = "UPDATE department SET name = ? WHERE department_id = ?";
        jdbcTemplate.update(sqlUpdate, updatedDepartment.getName(), updatedDepartment.getId());

    }


    @Override
    public Department createDepartment(Department department) {
        String sqlInsertDepartment = "INSERT INTO department ( department_id, name  ) VALUES (?, ?)";

        department.setId(getNextDepartmentId());
        jdbcTemplate.update(sqlInsertDepartment, department.getId(), department.getName());

        return department; //object
    }


    @Override
    public Department getDepartmentById(Long id) {
        Department theDepartment = null;

        String sqlGetDepById = "SELECT department_id, name FROM department WHERE department_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepById, id);
        while (results.next()) {
            theDepartment = mapRowToDepartment(results);

        }
        //ask why it had to insert Department in here
        return theDepartment;
    }

    private long getNextDepartmentId() {
        SqlRowSet nextIdResults = jdbcTemplate.queryForRowSet("SELECT nextval ('seq_department_id')");
        if (nextIdResults.next()) {
            return nextIdResults.getLong(1);
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new department");
        }
    }

    //helper method
    private Department mapRowToDepartment(SqlRowSet results) {
        // create an empty java object
        Department theDepartment = new Department();
        Long id = results.getLong("department_id");
        String name = results.getString("name");
        theDepartment.setId(id);
        theDepartment.setName(name);
        return theDepartment;
    }

}
