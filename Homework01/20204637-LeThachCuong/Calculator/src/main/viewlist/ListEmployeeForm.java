package main.viewlist;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import employee.action.IActionEmployee;
import employee.entity.Employee;

public class ListEmployeeForm extends JPanel {
	private static final long serialVersionUID = -6130161301802656552L;
	private JPanel tablePane;
	private IActionEmployee actionEditingAnEmployee;
	
	public ListEmployeeForm() {
		this.setLayout(new BorderLayout());
		
		JLabel txtHeading = new JLabel("Danh sách nhân viên");
		txtHeading.setFont(new Font(getName(), ABORT, 20));
		this.add(txtHeading, BorderLayout.NORTH);
		
		tablePane = new JPanel();
		this.add(tablePane, BorderLayout.CENTER);
	}
	
	public void addActionEditingAnEmployee(IActionEmployee action) {
		this.actionEditingAnEmployee = action;
	}
	
	public void displayListOfEmployee(List<Employee> list) {
		tablePane.removeAll();
		tablePane.revalidate();
		tablePane.repaint();
		tablePane.setLayout(new GridLayout(list.size(), 1));
		
		int index = 0;
		for (Employee emp: list) {
			JPanel rowPanel = new JPanel(); // Display Information of an Employee
			rowPanel.setLayout(new FlowLayout());
			rowPanel.setSize(100, HEIGHT);
			
			JLabel idLabel = new JLabel(emp.getId());
			JLabel fullNameLabel = new JLabel(emp.getFullName());
			JLabel yearOfExperienceLabel = new JLabel(emp.getYearOfExperience() + "");
			JButton editButton = new JButton("Edit");
			
			editButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					actionEditingAnEmployee.onAct(emp);
				}
			});
			
			rowPanel.add(idLabel);
			rowPanel.add(fullNameLabel);
			rowPanel.add(yearOfExperienceLabel);
			rowPanel.add(editButton);
			
			tablePane.add(rowPanel, index++);
		}
	}
}
