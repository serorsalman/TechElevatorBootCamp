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

	@Override
	// @Override says provide a body of the interface method
	public List<Department> getAllDepartments() {
		// create a java list to hold all the rows of Department objects coming from the db
		List<Department> departmentList = new ArrayList<>();
		// write our sql statement as a string
		String sqlGetAllDepartments = "SELECT department_id, name FROM department";

		// call the jdbcTemplate.queryForRowSet which returns the rows from the db
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);

		//loop through the rows
		while (results.next()){

			// create a new java object for each row that maps the db information to a java Department object
			Department theDepartment = mapRowToDepartment(results);

			// add the java department object to our list
			departmentList.add(theDepartment);
		}
		// return the list
		return departmentList;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {

		return new ArrayList<>();
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		
	}

	@Override
	public Department createDepartment(Department newDepartment) {

		return null;
	}

	@Override
	public Department getDepartmentById(Long id) {
		return null;
	}

	// map a row in the database to a java Department object
	private Department mapRowToDepartment(SqlRowSet results){
		// create an empty java object
		Department theDepartment = new Department();
		Long id = results.getLong("department_id");
		String name = results.getString("name");
		theDepartment.setId(id);
		theDepartment.setName(name);
		return theDepartment;
	}

}
