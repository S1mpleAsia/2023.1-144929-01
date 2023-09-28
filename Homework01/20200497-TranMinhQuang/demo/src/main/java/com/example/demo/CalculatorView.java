package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clrButton;
    JPanel panel;
    Font font = new Font("Ink Free", Font.BOLD, 30);

    public CalculatorView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i = 0;i < 8;i++) {
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(font);
        }

        for(int i = 0;i < 10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(font);
        }


        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setFont(font);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        this.add(delButton);
        this.add(clrButton);
        this.add(textField);
        this.add(panel);
    }

    public void addCalculateListener(ActionListener actionListener) {
        for(int i = 0;i < 8;i++) {
            functionButtons[i].addActionListener(actionListener);
        }

        for(int i = 0;i < 10;i++) {
            numberButtons[i].addActionListener(actionListener);
        }
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubButton() {
        return subButton;
    }

    public JButton getMulButton() {
        return mulButton;
    }

    public JButton getDivButton() {
        return divButton;
    }

    public JButton getDecButton() {
        return decButton;
    }

    public JButton getEqualButton() {
        return equalButton;
    }

    public JButton getDelButton() {
        return delButton;
    }

    public JButton getClrButton() {
        return clrButton;
    }

    void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this, errorMessage);

    }
}
