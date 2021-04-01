package Entities;

public class Employee  {

	private String name;
	private String email;
	private Double sal;
	
	public Employee() {
		
	}

	public Employee(String name, String email, Double sal) {
		super();
		this.name = name;
		this.email = email;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", sal=" + sal + "]";
	}
	 

}
