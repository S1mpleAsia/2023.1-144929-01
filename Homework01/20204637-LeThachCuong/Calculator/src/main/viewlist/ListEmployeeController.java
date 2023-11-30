package main.viewlist;

import java.util.List;

import employee.action.IActionEmployee;
import main.dbsubsystem.IEmployeeDB;
import employee.edit.EmployeeEditController;
import employee.edit.EmployeeEditForm;
import employee.entity.Employee;

public class ListEmployeeController {
	private ListEmployeeForm listEmployeeForm;
	private IEmployeeDB employeeSubsystem;
	
	public ListEmployeeController(ListEmployeeForm listEmployeeForm, IEmployeeDB employeeSubsystem) {
		this.listEmployeeForm = listEmployeeForm;
		this.employeeSubsystem = employeeSubsystem;
		fetchAndDisplayData(null, null);
		
		handleEditingAnEmployee();
	}
	
	private void handleEditingAnEmployee() {
		// Create Employee Edit Form
		EmployeeEditForm form = new EmployeeEditForm();
		IActionEmployee actionFinishEditing = new IActionEmployee() { // When user finish editing the Employee (press the save button)
			@Override
			public void onAct(Employee emp) {
				form.setVisible(false); // Employee Edit Form
				fetchAndDisplayData(null, null); // Reload and Update the List of Employee
			}
		};
		
		// Create the Controller for the Employee Edit Form
		new EmployeeEditController(form, actionFinishEditing);
		
		
		// When User edit an Employee (click the edit button)
		IActionEmployee editingAction = new IActionEmployee() {
			@Override
			public void onAct(Employee emp) {
				form.displayEmployee(emp); // Show the Employee data in the Employee Edit Form
				form.setVisible(true); // Show the Employee Edit Form
			}
		};	
		listEmployeeForm.addActionEditingAnEmployee(editingAction);
	}
	
	public void fetchAndDisplayData(String id, String fullName) {
		listEmployeeForm.displayListOfEmployee(getListEmployees(id, fullName));
	}
	
	public List<Employee> getListEmployees(String id, String fullName){
		return employeeSubsystem.getListEmployees(id, fullName);
	}
}
