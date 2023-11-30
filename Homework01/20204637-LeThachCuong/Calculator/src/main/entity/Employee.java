package main.entity;

public class Employee {
	private String id;
	private String fullName;
	private int yearOfExperience;
	
	
	public Employee(String id, String fullName, int yearOfExperience) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.yearOfExperience = yearOfExperience;
	}
	
	
	public Employee() {
		super();
	}
	
	@Override
	public String toString() {
		return id + "-" + fullName + "-" + yearOfExperience;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
}
