package main.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.action.IActionEmployee;
import main.dbsubsystem.IEmployeeDB;
import main.dbsubsystem.MemoryEmployeeDB;
import main.entity.Employee;

public class EmployeeEditController {
	public EmployeeEditController(EmployeeEditForm editForm, IActionEmployee actionFinishEditing) {
		IEmployeeDB db = new MemoryEmployeeDB();
		
		editForm.addActionSaveListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Employee emp = editForm.getEdittingEmployee();
				db.updateEmployee(emp);
				actionFinishEditing.onAct(emp);
			}
		});
	}
}
