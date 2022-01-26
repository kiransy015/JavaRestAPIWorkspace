package com.student.model;
import java.util.List;


public class Student {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String programme;
	
	private List<String> courses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Id : "+this.getId()+"\n"+"FirstName : "+this.getFirstName()+"\n"+"LastName : "+this.getLastName()+"\n"+"Email : "+this.getEmail()+"\n"+"Programme : "+this.getProgramme()+"\n"+"Courses : "+this.getCourses();
	}
	
	
	
}
