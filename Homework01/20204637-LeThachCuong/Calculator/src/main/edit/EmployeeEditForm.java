package main.edit;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.entity.Employee;

public class EmployeeEditForm extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtFullName;
	private JTextField txtYearOfExp;
	private JButton buttonSave;
	
	public EmployeeEditForm() {
		JPanel pane = createContentPane();
		add(pane);
		
		
		setLayout(new FlowLayout());
		setSize(300, 170);
	}
	
	public JPanel createContentPane() {
		JPanel pane = new JPanel();
		
		pane.setLayout(new GridLayout(4, 2));
		
		JLabel labelId = new JLabel("Employee ID");
		txtId = new JTextField();
		txtId.setEnabled(false);
		pane.add(labelId);
		pane.add(txtId);
		
		JLabel labelFullName = new JLabel("Full name");
		txtFullName = new JTextField();
		pane.add(labelFullName);
		pane.add(txtFullName);
		
		JLabel labelYearOfExp = new JLabel("Year of experience");
		txtYearOfExp = new JTextField();
		pane.add(labelYearOfExp);
		pane.add(txtYearOfExp);
		
		pane.add(new JLabel());
		
		buttonSave = new JButton("Save");
		pane.add(buttonSave);
		
		return pane;
	}
	
	public Employee getEdittingEmployee() {
		Employee emp = new Employee(txtId.getText(), txtFullName.getText(), Integer.parseInt(txtYearOfExp.getText()));
		return emp;
	}
	
	public void displayEmployee(Employee emp) {
		txtId.setText(emp.getId());
		txtFullName.setText(emp.getFullName());
		txtYearOfExp.setText(emp.getYearOfExperience() + "");
	}
	
	public void addActionSaveListener(ActionListener action) {
		buttonSave.addActionListener(action);
	}
}
