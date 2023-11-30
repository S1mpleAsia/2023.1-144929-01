package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import employee.action.IActionChangeAppGUI;
import employee.dbsubsystem.IEmployeeDB;
import employee.dbsubsystem.MemoryEmployeeDB;
import employee.viewlist.ListEmployeeController;
import employee.viewlist.ListEmployeeForm;

public class HomeController {
	private HomeForm homeForm;
	private IActionChangeAppGUI actionChangeGUI;
	
	public HomeController(HomeForm homeForm, IActionChangeAppGUI actionChangeGUI) {
		this.homeForm = homeForm;
		this.actionChangeGUI = actionChangeGUI;
		
		addActionViewListEmployee();
	}
	
	private void addActionViewListEmployee() {
		homeForm.addActionViewListEmployee(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create View
				ListEmployeeForm listEmployeeContainer = new ListEmployeeForm();
				
				// Create Model and Controller
				IEmployeeDB db = new MemoryEmployeeDB(); 
				new ListEmployeeController(listEmployeeContainer, db);
				
				// Change GUI (when view list employee button is clicked)
				actionChangeGUI.changeGUI(listEmployeeContainer);
			}
		});
	}
}
