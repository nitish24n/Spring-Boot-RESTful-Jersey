package controller;

import java.util.Hashtable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import service.EmployeeService;

@RestController
@Path("/employees")
public class EmployeeControlller {
	@Autowired
	EmployeeService emp;
	
	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
	
	@POST
	@Consumes("text/plain")
	public void postClichedMessage(String message) {
	    // Store the message
	}
	
	@GetMapping("/welcome")
	public String welcome(){
		return "Hello Man ... How's the life Going on";
	}
	
	@GetMapping("/all")
	public Hashtable<String,Employee> getAll() {
		return emp.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") String id) {
		return emp.getEmployee(id);
	}
	
	@PostMapping("/ViewBio/{luckyNo}")
	public String showBio(@RequestBody Employee empl,@PathVariable("luckyNo") Integer num) {
		System.out.println("Inside ViewBio ----!!");
		return "Hello"+empl.getFirstName()+" ! "+"You are "+empl.getAge()+" years old . Your lucky number is :"+num;
	}
} 