package com.jersey.resources;

//http://localhost:8080/RestWebservice/doj/application.wadl
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jersey.jaxb.Employee;

@Path("")
public class JSONXMLDemo {

	private static Map<String, Employee> employees = new HashMap<String, Employee>();

	static {

		Employee employee1 = new Employee();
		employee1.setEmployeeId("11111");
		employee1.setEmployeeName("Dineh Rajput");
		employee1.setJobType("Sr.Software Engineer");
		employee1.setSalary(70000l);
		employee1.setAddress("Noida");
		employees.put(employee1.getEmployeeId(), employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeId("22222");
		employee2.setEmployeeName("Abhishek");
		employee2.setJobType("Marketing");
		employee2.setSalary(50000l);
		employee2.setAddress("New Delhi");
		employees.put(employee2.getEmployeeId(), employee2);

	}

	@GET
	@Path("/employees/list/")
	@Produces({ "application/json", "application/xml" })
	public List<Employee> listEmployees() {
		return new ArrayList<Employee>(employees.values());
	}

	@GET
	@Path("/employee/get/{employeeid}")
	@Produces("application/json")
	public Employee getEmployee(@PathParam("employeeid") String employeeId) {
		return employees.get(employeeId);
	}

	@DELETE
	@Path("/employee/delete/{employeeid}")
	@Produces("text/plain")
	public String deleteEmployee(@PathParam("employeeid") String employeeId) {
		if (null != employees.remove(employeeId)) {
			return "Employee deleted";
		} else {
			return "No such employee";
		}
	}

	@PUT
	@Path("/employee/add")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Employee> addEmployee(Employee employee) {
		employees.put(employee.getEmployeeId(), employee);
		return new ArrayList<Employee>(employees.values());
	}

	@POST
	@Path("/employee/update/{employeeid}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateEmployee(@PathParam("employeeid") String employeeId,
			@DefaultValue("Madan") @QueryParam("employeeName") String employeeName, Employee employee) {
		System.out.println(employee);
		Employee emp = employees.get(employeeId);
		emp.setEmployeeName(employeeName);
		return Response.status(200)
				.entity(new ArrayList<Employee>(employees.values()))
				.type(MediaType.APPLICATION_JSON).build();

	}
}
