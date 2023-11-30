package main.dbsubsystem;

import java.util.ArrayList;
import java.util.List;

import employee.entity.Employee;

public class MemoryEmployeeDB implements IEmployeeDB{
	private static List<Employee> list = createAList();
	
	public MemoryEmployeeDB() {
	}
	
	private static List<Employee> createAList() {
		Employee e1 = new Employee("2000", "Nguyễn Lan Anh", 5);
		Employee e2 = new Employee("2001", "Nguyễn Hải Anh", 5);
		Employee e3 = new Employee("2002", "Nguyễn Văn Bắc", 5);
		Employee e4 = new Employee("2003", "Nguyễn Văn Đông", 5);
		
		ArrayList<Employee> res = new ArrayList<Employee>();
		res.add(e1);
		res.add(e2);
		res.add(e3);
		res.add(e4);
		
		return res;
	}
	
	@Override
	public List<Employee> getListEmployees(String id, String fullName) {
		List<Employee> res = new ArrayList<Employee>();
		for (Employee e: list) {
			boolean check1 = (id==null) || (id!=null && e.getId().contains(id));
			boolean check2 = (fullName==null) || (id!=null && e.getFullName().contains(fullName));
			
			if (check1 && check2) {
				res.add(e);
			}
		}
		return res;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		for (Employee e: list) {
			if (e.getId().equals(emp.getId())) {
				e.setFullName(emp.getFullName());
				e.setYearOfExperience(emp.getYearOfExperience());
				return true;
			}
		}
		return false;
	}
}
