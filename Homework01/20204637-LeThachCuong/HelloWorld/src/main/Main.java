package main;

import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("Enter Your Name: ");
        if(!name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hello " + name);
        }
    }
}
