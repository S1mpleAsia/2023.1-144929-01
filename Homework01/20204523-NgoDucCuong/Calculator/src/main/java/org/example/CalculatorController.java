package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;
    private Double firstNumber, secondNumber = (double) 0;
    private char operator;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;

        this.calculatorView.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) throws NumberFormatException {
            JTextField textField = calculatorView.getTextField();

            for(int i = 0;i < 10; i++) {
                if(e.getSource() == calculatorView.getNumberButtons()[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }

            if(e.getSource() == calculatorView.getDecButton()) {
                textField.setText(textField.getText().concat("."));
            }

            if(e.getSource() == calculatorView.getAddButton()) {
                try {
                    firstNumber = Double.parseDouble(textField.getText());
                } catch (NumberFormatException exception) {
                    calculatorView.displayErrorMessage("You need to enter valid number");
                }
                operator = '+';
                textField.setText("");
            }

            if(e.getSource() == calculatorView.getSubButton()) {
                if(Objects.equals(textField.getText(), "")) {
                    textField.setText("-");

                } else {
                    try {
                        firstNumber = Double.parseDouble(textField.getText());
                    } catch (NumberFormatException exception) {
                        calculatorView.displayErrorMessage("You need to enter valid number");
                    }
                    operator = '-';
                    textField.setText("");
                }
            }

            if(e.getSource() == calculatorView.getMulButton()) {
                try {
                    firstNumber = Double.parseDouble(textField.getText());
                } catch (NumberFormatException exception) {
                    calculatorView.displayErrorMessage("You need to enter valid number");
                }
                operator = '*';
                textField.setText("");
            }

            if(e.getSource() == calculatorView.getDivButton()) {
                try {
                    firstNumber = Double.parseDouble(textField.getText());
                } catch (NumberFormatException exception) {
                    calculatorView.displayErrorMessage("You need to enter valid number");
                }
                operator = '/';
                textField.setText("");
            }

            if(e.getSource() == calculatorView.getEqualButton()) {
                try {
                    secondNumber = Double.parseDouble(textField.getText());
                } catch (NumberFormatException exception) {
                    calculatorView.displayErrorMessage("You need to enter valid number");
                }

                switch (operator) {
                    case '+' : calculatorModel.addTwoNumbers(firstNumber, secondNumber);
                    case '-' : calculatorModel.subTwoNumbers(firstNumber, secondNumber);
                    case '*' : calculatorModel.multiplyTwoNumber(firstNumber, secondNumber);
                    case '/' : calculatorModel.dividedTwoNumber(firstNumber, secondNumber);
                }
                textField.setText(calculatorModel.getCalculationValue().toString());
                firstNumber = null;
                secondNumber = null;
            }

            if(e.getSource() == calculatorView.getClrButton()) {
                textField.setText("");
            }

            if(e.getSource() == calculatorView.getDelButton()) {
                String newValue = textField.getText().substring(0, textField.getText().length() - 1);

                textField.setText(newValue);
            }
        }
    }

}
