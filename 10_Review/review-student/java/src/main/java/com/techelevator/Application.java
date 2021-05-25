package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    // Create an instance variable
    private static List<Department> departments= new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static Map<String, Project> projects = new HashMap<>();





    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {// drop in points that calls the methods

        // lets call some departments call the method
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        Employee angie= employees.get(1);
        angie.raiseSalary(0.10);

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();

    }

    /**
     * Create departments and add them to the collection of departments
     */
    // create objects and add them to list
    private static void createDepartments() { // method
        Department d1= new Department(001 , "Marketing");
        Department d2= new Department(001 , "Sales");
        Department d3= new Department(001 , "Engineering");
        // add to the list
        departments.add(d1);
        departments.add(d2);
        departments.add(d3);
    }

    /**
     * Print out each department in the collection.
     */
    private static void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        // create for loop to print all department
        for ( Department department : departments){
            System.out.println(department.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private static void createEmployees() {
        Employee e1 = new Employee();// created using default constructor
        e1.setEmployeeId(001);
        e1.setFirstName("Dean");
        e1.setLastName("Johnson");
        e1.setEmail("djohnson@teams.com");
        e1.setSalary(60000.0);
        Department engineering = departments.get(2);// we need a department obj
        e1.setDepartment(engineering);// to load into our setDepartment
        e1.setHireDate("08/21/2020");

        Employee e2= new Employee( 002, "Angie", "Smith",
                "asmith@teams.com", engineering, "08/21/2020");
        Department marketing = departments.get(0);
        Employee e3 = new Employee(003,"Margaret", "Thompson", "mthompson@teams.com",
              marketing, "08/21/2020" );

        // add my employees to the Employee list
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);






    }

    /**
     * Print out each employee in the collection.
     */
    private static void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for ( Employee employees : employees) {
            System.out.println(employees.getFullName() + " (" + employees.getSalary() + ") " + employees.getDepartment().getName());

        }
    }

    /**
     * Create the 'TEams' project.
     */
    private static void createTeamsProject() {
        Project project = new Project("TEams", "Project Management Software","10/10/2020","11/10/2020" );

        List<Employee> engineeringTeam= new ArrayList<>();
        // find all the engeering to add to this project
        for(Employee employee: employees){
            // find out if the department is equal to engineering
            // if get emplyee's dept, then get the name of department
            // then see if it is equal to "engeering
            if ( employee.getDepartment().getName().equals("Engineering")){
                engineeringTeam.add(employee);
            }
        }
            project.setTeamMembers(engineeringTeam);
        //this project to the projects map
        projects.put(project.getName(), project);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private static void createLandingPageProject() {
        Project landingPage= new Project("Marketing Landing Page"," Lead Capture Landing Page for Marketing",
             "10/10/2020",   "10/17/2020" );
        List<Employee> marketingTeam= new ArrayList<>();
        for ( Employee employee:employees){
            if (employee.getDepartment().getName().equalsIgnoreCase("marketing")){
                marketingTeam.add(employee);
            }
        }
        landingPage.setTeamMembers(marketingTeam);
        projects.put(landingPage.getName(), landingPage);

    }

    /**
     * Print out each project in the collection.
     */
    private static void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> project : projects.entrySet()) {
        System.out.println(project.getKey() + ": " + project.getValue().getTeamMembers().size());
    }

    }

}
