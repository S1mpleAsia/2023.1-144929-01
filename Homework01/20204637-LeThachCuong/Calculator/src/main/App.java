package main;

import main.action.IActionChangeAppGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class App extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	
	public App() {
		pane = new JPanel();
		pane.setLayout(new FlowLayout());
		JButton homeButton = new JButton("Home");
		
		getContentPane().add(homeButton);
		getContentPane().add(pane);
		
		SpringLayout layout = new SpringLayout();
		getContentPane().setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, pane, 5, SpringLayout.SOUTH, homeButton);
	
		HomeForm homeForm = new HomeForm();
		pane.add(homeForm);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ứng dụng quản lý nhân viên");
		setSize(300, 350);
		setVisible(true);
		
		
		
		// when home button is clicked, load the Home Container
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updatePane(homeForm);
			}
		});

		// an utility object to change the GUI of the App
		IActionChangeAppGUI actionChangeGUI = new IActionChangeAppGUI() {
			@Override
			public void changeGUI(Container container) {
				updatePane(container);
			}
		};

		// initialize the controller
		new HomeController(homeForm, actionChangeGUI);
	}
	
	private void updatePane(Container container) {
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		pane.add(container);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new App();
			}
		});
	}
}
