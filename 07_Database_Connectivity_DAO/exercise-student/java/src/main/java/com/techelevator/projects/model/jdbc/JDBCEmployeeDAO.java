package com.techelevator.projects.model.jdbc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCEmployeeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {//Done
        List<Employee> employeeList = new ArrayList<>();
        String sqlGetAllEmployees = "SELECT employee_id, department_id, first_name," +
                " last_name,birth_date, gender, hire_date " +
                "FROM employee";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
        while (results.next()) {
            Employee theEmployee = mapRowToEmployee(results);
            employeeList.add(theEmployee);
        }
        return employeeList;
    }

    @Override
    public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) { //Done
        List<Employee> employeeList = new ArrayList<>();
        String sqlSearchEmployeesByName = "SELECT employee_id, department_id, first_name, last_name,birth_date, gender, hire_date FROM employee WHERE first_name = ? AND last_name= ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName, firstNameSearch, lastNameSearch);
        while (results.next()) {
            Employee theEmployee = mapRowToEmployee(results);
            employeeList.add(theEmployee);
        }
        return employeeList;

    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(long id) { //done
        List<Employee> employeeList = new ArrayList<>();
        String sqlSearchEmployeesByDepId = "SELECT employee_id, department_id, first_name, last_name,birth_date, gender, hire_date FROM employee WHERE department_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByDepId, id);
        while (results.next()) {
            Employee theEmployee = mapRowToEmployee(results);
            employeeList.add(theEmployee);
        }
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {
        List<Employee> employeeList = new ArrayList<>();
        String sqlGetEmployeeWithoutProject = "SELECT employee_id, first_name, last_name " +
                "FROM employee " +
                "Where employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeeWithoutProject);
        while (results.next()) {

            String stringTest= results.getString("first_name");
            String temName= results.getString("first_name");
            String temLasName= results.getString("last_name");
            Long tempEmployee_ID= results.getLong("employee_id");


            Employee theEmployee = new Employee(); // theEmployee called an object,
            theEmployee.setFirstName(temName);
            theEmployee.setLastName(temLasName);
            theEmployee.setId(tempEmployee_ID);
            employeeList.add(theEmployee);
        }
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByProjectId(Long projectId) {

        List<Employee> employeeList = new ArrayList<>();
        String sqlGetEmployeesProjectId = "SELECT employee.employee_id, first_name, last_name " +
                "from employee " +
                "join project_employee ON employee.employee_id = project_employee.employee_id " +
                "Where project_id= ?";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesProjectId, projectId);


        while (results.next()) {
            String stringTest= results.getString("first_name");
            String temName= results.getString("first_name");
            String temLasName= results.getString("last_name");
            Long tememployee_ID= results.getLong("employee_id");
          Employee theEmployee = new Employee();
          theEmployee.setFirstName(temName);
          theEmployee.setLastName(temLasName);
          theEmployee.setId(tememployee_ID);
            employeeList.add(theEmployee);
        }

        return employeeList;
    }

    @Override
    public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
        String sqlUpdate = "UPDATE employee " +
                " SET department_id = ? WHERE employee_id = ?";
        jdbcTemplate.update(sqlUpdate, departmentId, employeeId);

    }

    private Employee mapRowToEmployee(SqlRowSet results) {
        // create an empty java object
        Employee theEmployee = new Employee();
        Long id = results.getLong("employee_id");
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");
        Long depId = results.getLong("department_id");

        String gender = results.getString("gender");
        String hireDay = results.getString("hire_date");

        theEmployee.setId(id);
        theEmployee.setFirstName(firstName);
        theEmployee.setLastName(lastName);
        theEmployee.setDepartmentId(depId);
        theEmployee.setBirthDay(results.getDate("birth_date").toLocalDate());
        theEmployee.setGender(gender.charAt(0));
        theEmployee.setHireDate(hireDay);

        return theEmployee;
    }
}
