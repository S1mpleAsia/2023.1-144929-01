package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String inputName = JOptionPane.showInputDialog("Enter your name");

        if(!inputName.isEmpty()) JOptionPane.showMessageDialog(null, "Hello " + inputName);
    }
}