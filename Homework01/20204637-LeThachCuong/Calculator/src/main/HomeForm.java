package main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeForm extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton buttonViewListEmployee;
	
	public HomeForm() {
		this.setLayout(new GridLayout(2, 1));
		
		JLabel labelHeading = new JLabel("Ứng dụng quản lý nhân viên");
		labelHeading.setFont(new Font(getName(), ABORT, 20));
		this.add(labelHeading, 0);

		buttonViewListEmployee = new JButton("Xem danh sách nhân viên");
		this.add(buttonViewListEmployee, 1);
	}
	
	public void addActionViewListEmployee(ActionListener listener) {
		buttonViewListEmployee.addActionListener(listener);
	}
}
