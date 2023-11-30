package main.dbsubsystem;

import java.util.List;

import employee.entity.Employee;

public interface IEmployeeDB {
	public List<Employee> getListEmployees(String id, String name);
	public boolean updateEmployee(Employee emp);
}
