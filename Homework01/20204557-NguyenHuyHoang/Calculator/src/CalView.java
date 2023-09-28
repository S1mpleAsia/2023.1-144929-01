import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalView extends JFrame {
    JTextField tfInput;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[8];

    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton decimalButton, equalButton, deleteButton, clearButton;
    JPanel panel;

    Font calFont = new Font("Arial", Font.BOLD, 18);

    public CalView() {
        this.setSize(400, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfInput = new JTextField();
        tfInput.setBounds(50, 50, 300, 50);
        tfInput.setFont(calFont);
        tfInput.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("C");
        clearButton = new JButton("CE");

        funcButtons[0] = addButton;
        funcButtons[1] = subtractButton;
        funcButtons[2] = multiplyButton;
        funcButtons[3] = divideButton;
        funcButtons[4] = decimalButton;
        funcButtons[5] = equalButton;
        funcButtons[6] = deleteButton;
        funcButtons[7] = clearButton;

        for (int i = 0; i < 8; i++) {
            funcButtons[i].setFocusable(false);
            funcButtons[i].setFont(calFont);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFocusable(false);
            numButtons[i].setFont(calFont);
        }

        deleteButton.setBounds(50, 470, 145, 50);
        clearButton.setBounds(205, 470, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 130, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setFont(calFont);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subtractButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);

        this.add(deleteButton);
        this.add(clearButton);
        this.add(tfInput);
        this.add(panel);

    }

    public void addCalculateListener(ActionListener actionListener) {
        for (int i = 0; i < 8; i++) {
            funcButtons[i].addActionListener(actionListener);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i].addActionListener(actionListener);
        }
    }

    public JTextField getTfInput() {
        return tfInput;
    }

    public JButton[] getNumButtons() {
        return numButtons;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDecimalButton() {
        return decimalButton;
    }

    public JButton getEqualButton() {
        return equalButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    void displayErrorMessage(String errString) {
        JOptionPane.showMessageDialog(this, errString);
    }
}
